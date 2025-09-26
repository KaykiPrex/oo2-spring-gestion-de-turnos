package com.unla.grupo18.services.task;

import com.unla.grupo18.model.AppointmentDate;
import com.unla.grupo18.repositories.IAppointmentDateRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AppointmentDateTask {
    private IAppointmentDateRepository appointmentDateRepository;
    private static final int AVAILABLE_DAYS = 30;

    public AppointmentDateTask(IAppointmentDateRepository appointmentDateRepository) {
        this.appointmentDateRepository = appointmentDateRepository;
    }

    /***
     *  Cron diario para actualizar las fechas disponibles para los turnos
     */
    @Scheduled(cron = "* * * * * *")
    public void DailyDateValidation() {
        LocalDate hoy = LocalDate.now();
        List<AppointmentDate> appointmentDates = appointmentDateRepository.findAll();

        List<LocalDate> dates = new ArrayList<>();
        for (AppointmentDate appointmentDate : appointmentDates) {
            dates.add(appointmentDate.getDate());
        }

        Set<LocalDate> existentes = new HashSet<>(dates);
        List<LocalDate> faltantes = new ArrayList<>();

        for (int i = 0; i < AVAILABLE_DAYS; i++) {
            LocalDate fechaEsperada = hoy.plusDays(i);
            if (!existentes.contains(fechaEsperada)) {
                faltantes.add(fechaEsperada);
            }
        }

        if (!faltantes.isEmpty()) {
            for (LocalDate faltante : faltantes) {
                appointmentDateRepository.save(new AppointmentDate(faltante));
            }
        } else {
            System.out.println("No hay dias faltantes ya que existen 30 días desde hoy");
        }
    }

}
