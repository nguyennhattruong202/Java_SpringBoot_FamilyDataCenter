package com.nnt.fdcweb.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user_demo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDemo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 100)
    private String id;
    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 200)
    @NotBlank(message = "Full name is not empty")
    @NotNull(message = "Full name is not empty")
    @Size(max = 200, message = "Full name max size is 200 character")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Date of birth is not empty")
    @NotNull(message = "Date of birth is not empty")
    private LocalDate dateOfBirth;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 200)
    @Size(max = 200, message = "Email max size is 200 character")
    @Email(message = "Invalid email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 100)
    @NotBlank(message = "Password is not empty")
    @NotNull(message = "Password is not empty")
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters and maximum 100 characters")
    private String password;
    @Basic(optional = false)
    @Column(name = "role", nullable = false, length = 10)
    @NotBlank(message = "Role is not empty")
    @NotNull(message = "Role is not empty")
    private String role;
}
