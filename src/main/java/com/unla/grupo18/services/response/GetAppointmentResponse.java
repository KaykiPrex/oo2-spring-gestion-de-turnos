package com.unla.grupo18.services.response;

import java.time.LocalTime;

public record GetAppointmentResponse(int id, LocalTime time, boolean isReserved, ProfessionalResponse professional) {

}