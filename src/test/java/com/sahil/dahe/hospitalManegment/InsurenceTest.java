package com.sahil.dahe.hospitalManegment;

import com.sahil.dahe.hospitalManegment.entity.Appointment;
import com.sahil.dahe.hospitalManegment.entity.Insurence;
import com.sahil.dahe.hospitalManegment.entity.Patient;
import com.sahil.dahe.hospitalManegment.service.AppointmentService;
import com.sahil.dahe.hospitalManegment.service.InsurenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsurenceTest {
    @Autowired
    private InsurenceService insurenceService;//below you used it for metod call
@Autowired
private AppointmentService appointmentService;



    @Test

    public void testInsurence() {
        Insurence insurence = Insurence.builder().policyNumber("HDFC_1234").
                provider("HDFC Bank").validUntil(LocalDate.of(2030,12,12)).build();
      Patient patient =  insurenceService.assignInsurenceToPatient(insurence,1L);

      System.out.println(patient);


     var newPatient = insurenceService.disaccocidateInsurencefromPatient(patient.getId());
     System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder().appointmentTime
                        (LocalDateTime.of(2025, 12, 10, 14, 30)).reason("cancer")
                .build();
      var newAppointment =  appointmentService.createNewAppointment(appointment,1L,1L);
      System.out.println(newAppointment);

      var updatedAppointment = appointmentService.reCreateAppointment(newAppointment.getId(),3L);
      System.out.println(updatedAppointment);
    }
}
