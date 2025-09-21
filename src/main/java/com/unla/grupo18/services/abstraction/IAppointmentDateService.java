package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.model.AppointmentDate;

import java.util.List;

public interface IAppointmentDateService {
    AppointmentDate getAppointmentDateById(int id);
    List<AppointmentDate> getAllAppointmentDate();
}
