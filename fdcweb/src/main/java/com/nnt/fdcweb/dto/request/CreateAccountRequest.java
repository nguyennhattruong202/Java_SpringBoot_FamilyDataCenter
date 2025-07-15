package com.nnt.fdcweb.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountRequest {

    @NotNull(message = "Fullname cannot be null")
    @NotBlank(message = "Fullname cannot be blank")
    @Size(max = 200, message = "Fullname cannot be longer than 200 characters")
    private String fullname;
    @NotNull(message = "Gender cannot be null")
    @NotBlank(message = "Gender cannot be blank")
    @Size(max = 50, message = "Gender cannot be longer than 50 characters")
    private String gender;
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;
    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "Phone cannot be blank")
    @Size(max = 50, message = "Phone number cannot be longer than 50 characters")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number invalid")
    private String phone;
}
