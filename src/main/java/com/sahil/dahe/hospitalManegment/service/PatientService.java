package com.sahil.dahe.hospitalManegment.service;

import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient getpatientById(Long id) {
      Patient p1 =  patientRepository.findById(id) .orElseThrow(() -> new RuntimeException("Patient not found"));

return p1;
    }


}
