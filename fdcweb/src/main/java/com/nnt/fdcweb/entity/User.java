package com.nnt.fdcweb.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 200)
    private String fullname;
    @Basic(optional = false)
    @Column(name = "gender", nullable = false, length = 50)
    private String gender;
    @Basic(optional = false)
    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    @Basic(optional = false)
    @Column(name = "phone", nullable = false, length = 50, unique = true)
    private String phone;
    @Basic(optional = true)
    @Column(name = "email", nullable = true, length = 200)
    private String email;
    @Basic(optional = true)
    @Column(name = "citizen_identification_number", nullable = true, length = 50, unique = true)
    private String citizenIdentificationNumber;
    @Basic(optional = true)
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
    @Lob
    @Column(name = "note", nullable = true)
    private String note;
    @OneToOne(mappedBy = "user")
    private AuthCredentials authCredentials;
}
