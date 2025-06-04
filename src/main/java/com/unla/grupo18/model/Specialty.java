package com.unla.grupo18.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "specialty")
    private List<ProfessionalSpecialty> professionalSpecialties;
    @OneToMany(mappedBy = "specialty")
    private List<Service> services;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Specialty() {
    }

    public Specialty(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<ProfessionalSpecialty> getProfessionalSpecialties() {
        return professionalSpecialties;
    }

    public void setProfessionalSpecialties(List<ProfessionalSpecialty> professionalSpecialties) {
        this.professionalSpecialties = professionalSpecialties;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
