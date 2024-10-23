package com.nnt.fdcweb.services.implement;

import com.nnt.fdcweb.model.Hospital;
import com.nnt.fdcweb.repository.HospitalRepository;
import com.nnt.fdcweb.services.HospitalService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class HospitalServiceImplement implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Iterable<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital findById(Integer hospitalId) {
        Optional<Hospital> hospitalOptional = this.hospitalRepository.findById(hospitalId);
        return hospitalOptional.get();
    }

    @Override
    public void insertOrUpdate(Hospital hospital) {
        this.hospitalRepository.save(hospital);
    }

}
