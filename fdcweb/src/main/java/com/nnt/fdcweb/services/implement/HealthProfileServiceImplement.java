package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.HealthProfile;
import com.nnt.fdcweb.repository.HealthProfileRepository;
import com.nnt.fdcweb.services.HealthProfileService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class HealthProfileServiceImplement implements HealthProfileService {

    @Autowired
    private HealthProfileRepository healthProfileRepository;

    @Override
    public List<HealthProfile> findHealthProfileByPatientId(Integer patientId) {
        return this.healthProfileRepository.findHealthProfileByPatientId(patientId);
    }

    @Override
    public void insertOrUpdate(HealthProfile healthProfile) {
        this.healthProfileRepository.save(healthProfile);
    }

}
