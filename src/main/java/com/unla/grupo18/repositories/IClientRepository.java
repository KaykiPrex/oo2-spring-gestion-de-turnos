package com.unla.grupo18.repositories;

import com.unla.grupo18.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Appointment, Integer> {
}
