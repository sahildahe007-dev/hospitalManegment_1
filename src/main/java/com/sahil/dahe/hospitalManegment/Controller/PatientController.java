package com.sahil.dahe.hospitalManegment.Controller;

import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.repository.PatientRepository;
import com.sahil.dahe.hospitalManegment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;
    private final PatientService patientService;

    //  Create Patient
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    //  Get All Patients (with appointments)
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findByAllPatientWithAppointment();
    }

    //  Get Patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getpatientById(id);
    }

    // Delete Patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id){
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }
}
