package com.unla.grupo18.services;

import com.unla.grupo18.infrastructure.notification.MailSenderTitle;
import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Professional;
import com.unla.grupo18.repositories.IAppointmentRepository;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.services.abstraction.IAppointmentService;
import com.unla.grupo18.services.abstraction.IMailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;
    private final IMailSenderService mailSenderService;
    private final IClientRepository clientRepository;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository, IMailSenderService mailSenderService, IClientRepository clientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.mailSenderService = mailSenderService;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Appointment> getAppointmentsByProfessional(int professionalId) {
        return appointmentRepository.findByProfessionalId(professionalId);
    }

    @Override
    public List<Appointment> getAppointmentsByToday(int professionalId) {
        return appointmentRepository.findBydate(LocalDate.now());
    }

    @Override
    public List<Appointment> getAppointmentsByClient(int clientId) {
        return appointmentRepository.findByClientId(clientId);
    }

    @Override
    public List<Client> getClientsByProfessional(int professionalId) {
        return appointmentRepository.findDistinctClientsByProfessional(professionalId);
    }

    @Override
    public Appointment  getAppointmentsById(int id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointmentForProfessionalByAppointmentId(int id) throws MessagingException, UnsupportedEncodingException {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        String clientDisplayName = appointment.getClient().getName() + " " +appointment.getClient().getLastName();
        appointment.deleteClient();
        appointmentRepository.save(appointment);
        mailSenderService.sendMail(MailSenderTitle.CANCEL_APPOINTMENT_MAIL_TO_CLIENT,"mailto",clientDisplayName);  // ONLY FOR TEST // mailto = appointment.getProfessional().getContact().getWorkEmail();
    }

    @Override
    public List<Appointment> getAppointmentsForClient(Principal principal) {
        String username = principal.getName();

        int userId = clientRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"))
                .getId();
        return appointmentRepository.findByClientId(userId);
    }

    @Override
    public void assignClientToAppointment(Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            com.unla.grupo18.model.Appointment appointment = optionalAppointment.get();
            appointment.setClient(client);
            appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("No se pudo sacar turno");
        }
    }

    @Override
    public void create(Appointment appointment) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Professional professional = (Professional) auth.getPrincipal();
        appointment.setProfessional(professional);
        appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointmentForClientByAppointmentId(int id) throws MessagingException, UnsupportedEncodingException {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        String professionalDisplayName = appointment.getProfessional().getName() + " " +appointment.getProfessional().getLastName();
        appointment.deleteClient();
        appointmentRepository.save(appointment);
        mailSenderService.sendMail(MailSenderTitle.CANCEL_APPOINTMENT_MAIL_TO_PROFESSIONAL,"mailto",professionalDisplayName);  // ONLY FOR TEST // mailto = appointment.getProfessional().getContact().getWorkEmail();
    }

}
