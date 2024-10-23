package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.HealthProfile;
import java.util.List;

public interface HealthProfileService {

    List<HealthProfile> findHealthProfileByPatientId(Integer patientId);
    
    void insertOrUpdate(HealthProfile healthProfile);
}
