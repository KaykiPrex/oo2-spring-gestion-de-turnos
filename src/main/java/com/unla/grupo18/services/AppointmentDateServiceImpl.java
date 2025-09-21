package com.unla.grupo18.services;

import com.unla.grupo18.model.AppointmentDate;
import com.unla.grupo18.repositories.IAppointmentDateRepository;
import com.unla.grupo18.services.abstraction.IAppointmentDateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentDateServiceImpl implements IAppointmentDateService {
    private IAppointmentDateRepository appointmentDateRepository;

    public AppointmentDateServiceImpl(IAppointmentDateRepository appointmentDateRepository) {
        this.appointmentDateRepository = appointmentDateRepository;
    }

    @Override
    public AppointmentDate getAppointmentDateById(int id) {
        return appointmentDateRepository.findById(id).orElseThrow();
    }

    @Override
    public List<AppointmentDate> getAllAppointmentDate() {
        return appointmentDateRepository.findAll();
    }
}
