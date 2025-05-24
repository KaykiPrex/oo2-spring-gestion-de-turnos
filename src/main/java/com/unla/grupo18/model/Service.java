package com.unla.grupo18.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String duration;
    @OneToMany(mappedBy = "service")
    private List<ProfessionalService> professionalServices;
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;


    public Service(String name, String description, String duration ) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<ProfessionalService> getProfessionalServices() {
        return professionalServices;
    }

    public void setProfessionalServices(List<ProfessionalService> professionalServices) {
        this.professionalServices = professionalServices;
    }
}
