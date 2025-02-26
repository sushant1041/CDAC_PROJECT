package com.FirstProject.ClinicSystem.service;

import com.FirstProject.ClinicSystem.entity.Patient;
import com.FirstProject.ClinicSystem.repository.PatientRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists.");
        }

        try {
            return patientRepository.save(patient);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Error saving patient. Email may already exist.");
        }
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
