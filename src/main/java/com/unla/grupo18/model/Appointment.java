package com.unla.grupo18.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime time;
    @Column(name = "is_blocked")
    private boolean isBlocked;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "professional_service_id")
    private ProfessionalService professionalService;
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Report report;

    public Appointment() {
    }

    public Appointment(int id, LocalDate date, LocalTime time, boolean isBlocked, Professional professional) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.isBlocked = isBlocked;
        this.professional = professional;
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ProfessionalService getProfessionalService() {
        return professionalService;
    }

    public void setProfessionalService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
