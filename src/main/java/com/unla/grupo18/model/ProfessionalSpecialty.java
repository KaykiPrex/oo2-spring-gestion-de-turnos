package com.unla.grupo18.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "professional_specialty")
public class ProfessionalSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal status;
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

    public BigDecimal getPrice() {
        return status;
    }

    public void setPrice(BigDecimal price) {
        this.status = price;
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
