package com.nnt.fdcweb.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long userId;
    private String fullname;
    private String gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String ID;
    private String address;
    private String role;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String note;
}
