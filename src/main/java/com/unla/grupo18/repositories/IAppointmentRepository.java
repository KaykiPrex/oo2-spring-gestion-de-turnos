package com.unla.grupo18.repositories;

import com.unla.grupo18.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByProfessionalId(int professionalId);
    List<Appointment> findByClientId(int clientId);

}
