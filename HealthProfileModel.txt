package com.nnt.fdcweb.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "health_profile")
public class HealthProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "health_profile_id")
    private Integer healthProfileId;
    @Basic(optional = true)
    @Column(name = "code", nullable = true, length = 200)
    private String code;
    @Basic(optional = true)
    @Column(name = "type", nullable = true, length = 200)
    private String type;
    @Basic(optional = true)
    @Column(name = "health_insurance_id", nullable = true, length = 200)
    private String healthInsuranceId;
    @Lob
    @Column(name = "note", nullable = true)
    private String note;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patient;
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hospital hospital;

    public HealthProfile() {
    }

    public Integer getHealthProfileId() {
        return this.healthProfileId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setHealthInsuranceId(String healthInsuranceId) {
        this.healthInsuranceId = healthInsuranceId;
    }

    public String getHealthInsuranceId() {
        return this.healthInsuranceId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return this.note;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Hospital getHospital() {
        return this.hospital;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (healthProfileId != null ? healthProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HealthProfile)) {
            return false;
        }
        HealthProfile other = (HealthProfile) object;
        return !((this.healthProfileId == null && other.healthProfileId != null) || (this.healthProfileId != null && !this.healthProfileId.equals(other.healthProfileId)));
    }

    @Override
    public String toString() {
        return "com.nnt.fdcweb.model.Patient[ id=" + healthProfileId + " code=" + code + "]";
    }
}
