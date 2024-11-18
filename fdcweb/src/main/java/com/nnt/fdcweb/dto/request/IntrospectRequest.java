package com.nnt.fdcweb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntrospectRequest {

    @NotNull(message = "Token is not null")
    @NotBlank(message = "Token is not blank")
    private String token;
}
