package com.sahil.dahe.hospitalManegment.service;

import com.sahil.dahe.hospitalManegment.entity.Insurence;
import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.repository.DoctorRepository;
import com.sahil.dahe.hospitalManegment.repository.InsurenceRepository;
import com.sahil.dahe.hospitalManegment.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurenceService {
    private final InsurenceRepository insurenceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsurenceToPatient(Insurence insurence, Long patientId){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("patient not found with id"));

        patient.setInsurence(insurence);
        insurence.setPatient(patient);
        return patient;
    }
    @Transactional

    public Patient disaccocidateInsurencefromPatient(Long patientId){

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("patient not found with id"));
        patient.setInsurence(null);
        return patient;
    }
}
