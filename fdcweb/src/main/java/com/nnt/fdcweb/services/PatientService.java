package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.Patient;
import java.util.List;

public interface PatientService {

    Iterable<Patient> findAll();

    Patient findById(Integer patientId);

    void insert(Patient patient);

    void update(Patient patient);

    void deleteById(Integer patientId);
    
    void deleteAllById(List<Integer> patientIds);
}
