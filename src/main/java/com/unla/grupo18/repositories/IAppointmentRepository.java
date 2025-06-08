package com.unla.grupo18.repositories;

import com.unla.grupo18.model.Appointment;
import com.unla.grupo18.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByProfessionalId(int professionalId);
    List<Appointment> findByClientId(int clientId);
    List<Appointment> findBydate(LocalDate date);
    @Query("SELECT DISTINCT a.client FROM Appointment a WHERE a.professional.id = :professionalId")
    List<Client> findDistinctClientsByProfessional(@Param("professionalId") int professionalId);

}
