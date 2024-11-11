package com.nnt.fdcweb.dto.request;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Size(max = 200, message = "Fullname max size is 200 character")
    private String fullname;
    @NotBlank(message = "Gender is not empty")
    @NotNull(message = "Gender is not null")
    @Size(max = 10, message = "Gender max size is 10 character")
    private String gender;
    @NotNull(message = "Date of birth is not null")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Phone is not empty")
    @NotNull(message = "Phone is not null")
    @Size(max = 20, message = "Phone max size is 20 character")
    private String phone;
    @Size(max = 200, message = "Email max size is 200 character")
    @Email(message = "Invalid email")
    private String email;
    @Size(max = 20, message = "ID max size is 20 character")
    private String ID;
    @Size(max = 200, message = "Address max size is 200 character")
    private String address;
    @NotBlank(message = "Password is not empty")
    @NotNull(message = "Password is not null")
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters and maximum 100 characters")
    private String password;
    private String note;
}
