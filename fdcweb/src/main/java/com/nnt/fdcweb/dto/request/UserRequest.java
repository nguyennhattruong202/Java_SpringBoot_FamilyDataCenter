package com.nnt.fdcweb.dto.request;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
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
public class UserRequest {

    @NotNull(message = "Fullname is not null")
    @NotBlank(message = "Fullname is not blank")
    @Size(max = 200, message = "Fullname max size is 200 character")
    private String fullname;
    @NotNull(message = "Gender is not null")
    @NotBlank(message = "Gender is not blank")
    @Size(max = 10, message = "Gender max size is 10 character")
    private String gender;
    @NotNull(message = "Date of birth is not null")
    private LocalDate dateOfBirth;
    @NotNull(message = "Phone is not null")
    @NotBlank(message = "Phone is not blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number invalid")
    private String phone;
    @Email(message = "Email is not valid")
    @Size(max = 200, message = "Email max size is 200 character")
    private String email;
    @Size(max = 10, message = "ID max size is 10 character")
    private String ID;
    @Size(max = 200, message = "Address max size is 200 character")
    private String address;
    @NotNull(message = "Password is not null")
    @NotBlank(message = "Password is not blank")
    private String password;
    private String note;
}
