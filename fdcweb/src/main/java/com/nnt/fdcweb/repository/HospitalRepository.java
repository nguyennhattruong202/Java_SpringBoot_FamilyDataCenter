package com.nnt.fdcweb.repository;

import com.nnt.fdcweb.model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

}
