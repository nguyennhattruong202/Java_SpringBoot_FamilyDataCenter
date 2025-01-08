package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.controllers.exception.AppException;
import com.nnt.fdcweb.dto.request.AuthCredentialsRequest;
import com.nnt.fdcweb.dto.request.SignInRequest;
import com.nnt.fdcweb.dto.response.AuthCredentialsResponse;
import com.nnt.fdcweb.entity.AuthCredentials;
import com.nnt.fdcweb.entity.User;
import com.nnt.fdcweb.enums.ErrorCode;
import com.nnt.fdcweb.mapper.AuthCredentialsMapper;
import com.nnt.fdcweb.repository.AuthCredentialsRepository;
import com.nnt.fdcweb.repository.UserRepository;
import com.nnt.fdcweb.services.AuthCredentialsService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AuthCredentialsServiceImplement implements AuthCredentialsService {

    private final AuthCredentialsRepository authCredentialsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthCredentialsServiceImplement(AuthCredentialsRepository authCredentialsRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authCredentialsRepository = authCredentialsRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signIn(SignInRequest signInRequest) {
        AuthCredentials authCredentials = authCredentialsRepository
                .findByPhone(signInRequest.getPhone()).orElseThrow(()
                -> new AppException(ErrorCode.INVALID_CREDENTIALS));
        if (!passwordEncoder.matches(signInRequest.getPassword(), authCredentials
                .getPassword())) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }
        return authCredentials.getUser();
    }

    @Override
    public AuthCredentialsResponse createPassword(String userId, AuthCredentialsRequest authCredentialsRequest) {
        Optional<User> user = userRepository.findById(userId);
        authCredentialsRequest.setPassword(passwordEncoder.encode(authCredentialsRequest.getPassword()));
        AuthCredentials authCredentials = authCredentialsRepository.save(AuthCredentialsMapper.toAuthCredentials(user.get(), authCredentialsRequest));
        return AuthCredentialsMapper.toAuthCredentialsResponse(authCredentials);
    }
}
