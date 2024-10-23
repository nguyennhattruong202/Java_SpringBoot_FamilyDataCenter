package com.nnt.fdcweb.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "wp_table1")
@NamedQueries({
    @NamedQuery(name = "WpTable1.findAll", query = "SELECT w FROM WpTable1 w"),
    @NamedQuery(name = "WpTable1.findById", query = "SELECT w FROM WpTable1 w WHERE w.id = :id"),
    @NamedQuery(name = "WpTable1.findByFullname", query = "SELECT w FROM WpTable1 w WHERE w.fullname = :fullname")})
public class WpTable1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 200)
    private String fullname;
    @Basic(optional = false)
    @Column(name = "date_of_birth", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
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

    public WpTable1() {
    }

    public WpTable1(String fullname, LocalDate dateOfBirth, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime createdDate) {
        this.updatedDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WpTable1)) {
            return false;
        }
        WpTable1 other = (WpTable1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnt.fdcweb.model.WpTable1[ id=" + id + " fullname=" + fullname + "]";
    }

}
