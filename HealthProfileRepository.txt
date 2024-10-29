package com.nnt.fdcweb.repository;

import com.nnt.fdcweb.model.HealthProfile;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthProfileRepository extends CrudRepository<HealthProfile, Integer> {

    @Query("SELECT h FROM HealthProfile h WHERE h.patient.patientId = :patientId")
    List<HealthProfile> findHealthProfileByPatientId(@Param("patientId") Integer patientId);
}
