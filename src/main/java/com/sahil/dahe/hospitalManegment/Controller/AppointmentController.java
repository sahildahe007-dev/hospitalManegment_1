package com.sahil.dahe.hospitalManegment.Controller;

import com.sahil.dahe.hospitalManegment.entity.Appointment;
import com.sahil.dahe.hospitalManegment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // ✅ Create Appointment (must have patient + doctor)
    @PostMapping("/patient/{patientId}/doctor/{doctorId}")
    public Appointment createAppointment(
            @RequestBody Appointment appointment,
            @PathVariable Long patientId,
            @PathVariable Long doctorId){

        return appointmentService.createNewAppointment(appointment, doctorId, patientId);
    }

    // ✅ Change Doctor (Reassign appointment)
    @PutMapping("/{appointmentId}/doctor/{doctorId}")
    public Appointment updateDoctor(
            @PathVariable Long appointmentId,
            @PathVariable Long doctorId){

        return appointmentService.reCreateAppointment(appointmentId, doctorId);
    }
}