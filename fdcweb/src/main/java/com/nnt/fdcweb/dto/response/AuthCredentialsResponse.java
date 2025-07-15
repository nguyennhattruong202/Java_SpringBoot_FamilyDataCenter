package com.nnt.fdcweb.dto.response;

import com.nnt.fdcweb.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthCredentialsResponse {

    private Long id;
    private String phone;
    private String password;
    private User user;
}
