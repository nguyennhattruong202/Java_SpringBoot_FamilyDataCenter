package com.nnt.fdcweb.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountResponse {

    private String id;
    private String fullname;
    private String gender;
    private LocalDate dateOfBirth;
    private String phone;
}
