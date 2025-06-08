package com.unla.grupo18.services;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.repositories.IAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final IAppointmentRepository appointmentRepository;

    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointmentsByProfessional(int professionalId) {
        return appointmentRepository.findByProfessionalId(professionalId);
    }
    public List<Appointment> getAppointmentsByClient(int clientId) {
        return appointmentRepository.findByClientId(clientId);
    }

    public Appointment  getAppointmentsById(int id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

}
