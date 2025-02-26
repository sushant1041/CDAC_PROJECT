package com.FirstProject.ClinicSystem.repository;

import com.FirstProject.ClinicSystem.entity.Appointment;
import com.FirstProject.ClinicSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);
}

