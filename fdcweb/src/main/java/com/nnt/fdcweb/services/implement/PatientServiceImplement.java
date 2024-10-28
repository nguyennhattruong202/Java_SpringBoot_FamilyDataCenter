package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.Patient;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnt.fdcweb.repository.PatientRepository;
import com.nnt.fdcweb.services.PatientService;
import java.util.List;

@Transactional
@Service
public class PatientServiceImplement implements PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }
    
    @Override
    public Patient findById(Integer patientId) {
        Optional<Patient> patientOptional = this.patientRepository.findById(patientId);
        return patientOptional.get();
    }
    
    @Override
    public void insert(Patient patient) {
        patient.setCreatedDate(LocalDateTime.now());
        patient.setUpdatedDate(LocalDateTime.now());
        this.patientRepository.save(patient);
    }
    
    @Override
    public void update(Patient patient) {
        patient.setUpdatedDate(LocalDateTime.now());
        this.patientRepository.save(patient);
    }
    
    @Override
    public void deleteById(Integer patientId) {
        this.patientRepository.deleteById(patientId);
    }
    
    @Override
    public void deleteAllById(List<Integer> patientIds) {
        this.patientRepository.deleteAllById(patientIds);
    }
    
}
