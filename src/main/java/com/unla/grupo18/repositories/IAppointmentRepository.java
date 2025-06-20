package com.unla.grupo18.repositories;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByProfessionalId(int professionalId);
    List<Appointment> findByClientId(int clientId);
    List<Appointment> findBydate(LocalDate date);
    @Query("SELECT DISTINCT a.client FROM Appointment a WHERE a.professional.id = :professionalId AND a.client IS NOT NULL")
    List<Client> findDistinctClientsByProfessional(@Param("professionalId") int professionalId);
    @Query("SELECT a.client FROM Appointment a WHERE a.client.username = :username")
    Client findByUsername(@Param("username") String username);


}
