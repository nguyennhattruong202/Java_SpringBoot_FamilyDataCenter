package com.nnt.fdcweb.repository;

import com.nnt.fdcweb.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
