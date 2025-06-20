package com.unla.grupo18.model;

import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "professional")
public class Professional extends User{
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String cuil;
    @ManyToMany
    @JoinTable(
            name = "professional_specialty",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private List<Specialty> specialties;
    @ManyToMany
    @JoinTable(
            name = "professional_service",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

    public Professional() {
    }

    public Professional(String name, String lastName, String cuil, List<Specialty> specialties) {
        this.name = name;
        this.lastName = lastName;
        this.cuil = cuil;
        this.specialties = specialties;
    }

    public Professional(String userName, String userPass, Contact contact, String name, String lastName, String cuil, LocalTime initWorkHour, LocalTime endWorkHour, String workDays, List<Specialty> specialties) {
        super(userName, userPass, contact);
        this.name = name;
        this.lastName = lastName;
        this.cuil = cuil;
        this.specialties = specialties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
