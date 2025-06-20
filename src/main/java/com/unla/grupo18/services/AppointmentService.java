package com.unla.grupo18.services;

import com.unla.grupo18.infrastructure.exception.EntityNotFoundException;
import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.repositories.IAppointmentRepository;
import com.unla.grupo18.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;

    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointmentsByProfessional(int professionalId) {
        return appointmentRepository.findByProfessionalId(professionalId);
    }
    public List<Appointment> getAppointmentsByToday(int professionalId) {
        return appointmentRepository.findBydate(LocalDate.now());
    }
    public List<Appointment> getAppointmentsByClient(int clientId) {
        return appointmentRepository.findByClientId(clientId);
    }
    public Appointment getById(int id){
        return appointmentRepository.getById(id);
    }
    public void save(Appointment appointment){
        appointmentRepository.save(appointment);
    }
    public List<Client> getClientsByProfessional(int professionalId) {
        return appointmentRepository.findDistinctClientsByProfessional(professionalId);
    }
    public void assignClientToAppointment(int appointmentId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        Appointment appointment = getById(appointmentId);
        if (appointment == null) {
            throw new EntityNotFoundException("Turno no encontrado");
        }

        appointment.setClient(client);
        save(appointment);
    }
    public List<Appointment> getAppointmentsForClient(Principal principal) {
        String username = principal.getName();
        IClientRepository clientRepository = null;
        Client client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return getAppointmentsByClient(client.getUserId());
    }

    public Appointment  getAppointmentsById(int id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }


    public Optional<Client> findByUsername(String username) {
        return Optional.ofNullable(appointmentRepository.findByUsername(username));
    }
}
