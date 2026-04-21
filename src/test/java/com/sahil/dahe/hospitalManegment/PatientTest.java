package com.sahil.dahe.hospitalManegment;

import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.repository.PatientRepository;
import com.sahil.dahe.hospitalManegment.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientsList = patientRepository.findByAllPatientWithAppointment();
        System.out.println(patientsList);
    }
    @Test
    public void testPatientRepository2() {
       Patient patient= patientService.getpatientById(1L);
        System.out.println(patient);
    }


}
