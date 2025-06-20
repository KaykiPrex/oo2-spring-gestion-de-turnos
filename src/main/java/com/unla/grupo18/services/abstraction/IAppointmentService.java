package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAppointmentsByProfessional(int professionalId);
    List<Appointment> getAppointmentsByToday(int professionalId);
    List<Appointment> getAppointmentsByClient(int clientId);
    List<Client> getClientsByProfessional(int professionalId);
    Appointment  getAppointmentsById(int id);
    void updateAppointment(Appointment appointment);
    void cancelAppointmentForClientByAppointmentId(int id) throws MessagingException, UnsupportedEncodingException;
    void cancelAppointmentForProfessionalByAppointmentId(int id) throws MessagingException, UnsupportedEncodingException;

    List<Appointment> getAppointmentsForClient(Principal principal);

    void assignClientToAppointment(Integer id);
}
