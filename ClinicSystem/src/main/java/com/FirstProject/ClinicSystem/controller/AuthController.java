package com.FirstProject.ClinicSystem.controller;

import com.FirstProject.ClinicSystem.entity.Patient;
import com.FirstProject.ClinicSystem.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final PatientService patientService;

    public AuthController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient loginRequest) {
        Optional<Patient> patient = patientService.getPatientByEmail(loginRequest.getEmail());

        if (patient.isPresent() && patient.get().getPassword().equals(loginRequest.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("token", "dummy-jwt-token");
            response.put("name", patient.get().getName());
            response.put("email", patient.get().getEmail());
            response.put("role", "patient");

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("Invalid email or password.");
    }
}
