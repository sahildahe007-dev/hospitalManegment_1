package com.sahil.dahe.hospitalManegment.repository;

import com.sahil.dahe.hospitalManegment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
