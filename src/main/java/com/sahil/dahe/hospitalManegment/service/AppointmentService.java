package com.sahil.dahe.hospitalManegment.service;

import com.sahil.dahe.hospitalManegment.entity.Appointment;
import com.sahil.dahe.hospitalManegment.entity.Doctor;
import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.repository.AppointmentRepository;
import com.sahil.dahe.hospitalManegment.repository.DoctorRepository;
import com.sahil.dahe.hospitalManegment.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
@Transactional
    public Appointment createNewAppointment(Appointment appointment, long doctor_id, long patient_id) {

        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow();
        Patient patient = patientRepository.findById(patient_id).orElseThrow();

        if(appointment.getId()!=null){
            throw new IllegalArgumentException("Appointment already exists");
        }

        appointment.setPatient(patient);

        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);//for bidirectional consistency

       return appointmentRepository.save(appointment);


    }
    @Transactional
    public Appointment reCreateAppointment(Long appointmentId,Long doctorId){
    Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
    Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointment.setDoctor(doctor);//this will automatically call the update

        doctor.getAppointments().add(appointment);//only for bidirectional
        return appointment;
    }
}
