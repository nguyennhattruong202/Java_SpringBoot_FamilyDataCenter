package com.nnt.fdcweb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequest {

    @NotNull(message = "Phone is not null")
    @NotBlank(message = "Phone is not blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number invalid")
    private String phone;
    @NotNull(message = "Password is not null")
    @NotBlank(message = "Password is not blank")
    private String password;
}
