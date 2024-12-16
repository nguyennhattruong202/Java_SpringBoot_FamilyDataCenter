package com.nnt.fdcweb.services.implement;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.nnt.fdcweb.controllers.exception.AppException;
import com.nnt.fdcweb.dto.request.AuthenticationRequest;
import com.nnt.fdcweb.dto.request.IntrospectRequest;
import com.nnt.fdcweb.dto.response.AuthenticationResponse;
import com.nnt.fdcweb.dto.response.IntrospectResponse;
import com.nnt.fdcweb.enums.ResponseCode;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.AuthenticationService;
import jakarta.transaction.Transactional;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AuthenticationServiceImplement implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Value("${jwt.signer-key}")
    private String SIGNER_KEY;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private String generateToken(User user) {
        JWSHeader jWSHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jWTClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getPhone())
                .issuer("fdcweb")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("scope", user.getRole())
                .build();
        Payload payload = new Payload(jWTClaimsSet.toJSONObject());
        JWSObject jWSObject = new JWSObject(jWSHeader, payload);
        try {
            jWSObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jWSObject.serialize();
        } catch (JOSEException e) {
            throw new AppException(ResponseCode.CANNOT_GENERATE_TOKEN);
        }
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {

        User user = this.userRepository.findByPhone(authenticationRequest.getPhone()).orElse(null);
        if (user == null) {
            return new AuthenticationResponse(ResponseCode.NOT_EXISTS.getCode(),
                    ResponseCode.NOT_EXISTS.name(), null);
        }
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if (!authenticated) {
            return new AuthenticationResponse(ResponseCode.UNAUTHENTICATED.getCode(),
                    ResponseCode.UNAUTHENTICATED.name(), null);
        }
        return new AuthenticationResponse(ResponseCode.AUTHENTICATED.getCode(),
                ResponseCode.AUTHENTICATED.name(), generateToken(user));
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        String token = introspectRequest.getToken();
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        boolean verified = signedJWT.verify(verifier);
        IntrospectResponse introspectResponse = new IntrospectResponse();
        if (verified && expiryTime.after(new Date())) {
            introspectResponse.setCode(ResponseCode.TOKEN_OK.getCode());
            introspectResponse.setMessage(ResponseCode.TOKEN_OK.name());
        } else {
            introspectResponse.setCode(ResponseCode.INVALID_TOKEN.getCode());
            introspectResponse.setMessage(ResponseCode.INVALID_TOKEN.name());
        }
        return introspectResponse;
    }
}
