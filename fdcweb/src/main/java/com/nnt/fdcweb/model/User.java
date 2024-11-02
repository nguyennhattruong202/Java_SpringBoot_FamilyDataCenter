package com.nnt.fdcweb.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 200)
    @NotBlank(message = "Full name is not empty")
    @NotNull(message = "Full name is not empty")
    @Size(max = 200, message = "Full name max size is 200 character")
    private String fullname;
    @Basic(optional = false)
    @Column(name = "gender", nullable = false, length = 10)
    @NotBlank(message = "Gender is not empty")
    @NotNull(message = "Gender is not empty")
    @Size(max = 10, message = "Gender max size is 10 character")
    private String gender;
    @Basic(optional = false)
    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Date of birth is not empty")
    @NotNull(message = "Date of birth is not empty")
    private LocalDate dateOfBirth;
    @Basic(optional = false)
    @Column(name = "phone", nullable = false, length = 20, unique = true)
    @NotBlank(message = "Phone is not empty")
    @NotNull(message = "Phone is not empty")
    @Size(max = 20, message = "Phone max size is 20 character")
    private String phone;
    @Basic(optional = true)
    @Column(name = "email", nullable = true, length = 200)
    @Size(max = 200, message = "Email max size is 200 character")
    @Email(message = "Invalid email")
    private String email;
    @Basic(optional = true)
    @Column(name = "id", nullable = true, length = 20)
    @Size(max = 20, message = "ID max size is 20 character")
    private String ID;
    @Basic(optional = true)
    @Column(name = "address", nullable = true, length = 200)
    @Size(max = 200, message = "Address max size is 200 character")
    private String address;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 100)
    @NotBlank(message = "Password is not empty")
    @NotNull(message = "Password is not empty")
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters and maximum 100 characters")
    private String password;
    @Basic(optional = false)
    @Column(name = "role", nullable = false, length = 10)
    private String role;
    @Basic(optional = false)
    @Column(name = "created_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;
    @Basic(optional = false)
    @Column(name = "updated_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedDate;
    @Lob
    @Column(name = "note", nullable = true)
    private String note;

    public User() {
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullName() {
        return this.fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return this.note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)));
    }

    @Override
    public String toString() {
        return "com.nnt.fdcweb.model.User \nUser id: " + this.userId
                + "\nFullname: " + this.fullname
                + "\nGender: " + this.gender
                + "\nPhone: " + this.phone
                + "\nEmail: " + this.email
                + "\nID: " + this.ID
                + "\nAddress: " + this.address
                + "\nPassword: " + this.password
                + "\nRole: " + this.role;
    }
}
