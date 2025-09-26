package com.unla.grupo18.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "appointment_date")
public class AppointmentDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String notes;
    @OneToMany(mappedBy = "appointmentDate", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public AppointmentDate() {
    }

    public AppointmentDate(int id, LocalDate date, String notes) {
        this.id = id;
        this.date = date;
        this.notes = notes;
    }

    public AppointmentDate(LocalDate date) {
        this.date = date;
    }

    public AppointmentDate(LocalDate date, String notes) {
        this.date = date;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
