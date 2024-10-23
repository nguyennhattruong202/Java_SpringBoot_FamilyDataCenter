package com.nnt.fdcweb.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hospital_id")
    private Integer hospitalId;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic(optional = false)
    @Column(name = "address", nullable = false, length = 200)
    private String address;
    @Basic(optional = true)
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic(optional = true)
    @Column(name = "email", nullable = true, length = 200)
    private String email;
    @Basic(optional = true)
    @Column(name = "url", nullable = true, length = 200)
    private String url;
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HealthProfile> healthProfileSet;

    public Hospital() {
    }

    public Integer getHospitalId() {
        return this.hospitalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHealthProfileSet(Set<HealthProfile> healthProfileSet) {
        this.healthProfileSet = healthProfileSet;
    }

    public Set<HealthProfile> getHealthProfileSet() {
        return this.healthProfileSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospitalId != null ? hospitalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        return !((this.hospitalId == null && other.hospitalId != null) || (this.hospitalId != null && !this.hospitalId.equals(other.hospitalId)));
    }

    @Override
    public String toString() {
        return "com.nnt.fdcweb.model.Hospital[ id=" + hospitalId + " name=" + name + "]";
    }
}
