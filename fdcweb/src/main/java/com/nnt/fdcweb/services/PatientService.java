package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.Patient;

public interface PatientService {

    Iterable<Patient> findAll();

    Patient findById(Integer patientId);

    void insert(Patient patient);

    void update(Patient patient);

    void deleteById(Integer patientId);
}
