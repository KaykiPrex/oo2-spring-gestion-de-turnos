package com.unla.grupo18.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professional_specialty")
public class ProfessionalSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    public ProfessionalSpecialty() {
    }

    public ProfessionalSpecialty(int id, Specialty specialty) {
        this.id = id;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Specialty getService() {
        return specialty;
    }

    public void setService(Specialty specialty) {
        this.specialty = specialty;
    }
}
