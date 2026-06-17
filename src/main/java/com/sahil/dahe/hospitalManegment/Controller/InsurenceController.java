package com.sahil.dahe.hospitalManegment.Controller;

import com.sahil.dahe.hospitalManegment.entity.Insurence;
import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.service.InsurenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
@RequiredArgsConstructor
public class InsurenceController {

    private final InsurenceService insurenceService;

    // Assign Insurance to Patient
    @PostMapping("/patient/{patientId}")
    public Patient assignInsurance(
            @RequestBody Insurence insurence,
            @PathVariable Long patientId){

        return insurenceService.assignInsurenceToPatient(insurence, patientId);
    }

    //  Remove Insurance
    @DeleteMapping("/patient/{patientId}")
    public Patient removeInsurance(@PathVariable Long patientId){
        return insurenceService.disaccocidateInsurencefromPatient(patientId);
    }
}