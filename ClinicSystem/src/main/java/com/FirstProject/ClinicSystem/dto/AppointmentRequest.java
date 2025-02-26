package com.FirstProject.ClinicSystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppointmentRequest {
    private String email;
    private String problem;

}