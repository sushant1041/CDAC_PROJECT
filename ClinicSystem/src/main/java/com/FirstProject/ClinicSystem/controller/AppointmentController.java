package com.FirstProject.ClinicSystem.controller;

import com.FirstProject.ClinicSystem.dto.AppointmentRequest;
import com.FirstProject.ClinicSystem.entity.Appointment;
import com.FirstProject.ClinicSystem.entity.Patient;
import com.FirstProject.ClinicSystem.service.AppointmentService;
import com.FirstProject.ClinicSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> saveAppointment(@RequestBody AppointmentRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank() || request.getProblem() == null || request.getProblem().isBlank()) {
            return ResponseEntity.badRequest().body("Email and problem description are required.");
        }

        Optional<Patient> patientOpt = patientService.getPatientByEmail(request.getEmail());
        if (patientOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Patient not found.");
        }

        Patient patient = patientOpt.get();
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setProblem(request.getProblem());
        appointment.setAppointmentDate(LocalDateTime.now());

        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<List<Appointment>> getAppointmentsByEmail(@PathVariable String email) {
        Optional<Patient> patientOpt = patientService.getPatientByEmail(email);

        if (patientOpt.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        List<Appointment> appointments = appointmentService.getAppointmentsByPatient(patientOpt.get());
        return ResponseEntity.ok(appointments);
    }

}
