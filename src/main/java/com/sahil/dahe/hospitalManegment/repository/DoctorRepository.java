package com.sahil.dahe.hospitalManegment.repository;

import com.sahil.dahe.hospitalManegment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
