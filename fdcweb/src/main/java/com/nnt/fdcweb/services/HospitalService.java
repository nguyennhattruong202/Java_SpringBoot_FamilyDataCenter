package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.Hospital;

public interface HospitalService {

    Iterable<Hospital> findAll();

    Hospital findById(Integer hospitalId);

    void insertOrUpdate(Hospital hospital);
}
