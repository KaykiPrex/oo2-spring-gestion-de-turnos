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
    @Column(name = "init_work_hour")
    private LocalTime initWorkHour;
    @Column(name = "end_work_hour")
    private LocalTime endWorkHour;
    @Column(name = "work_days")
    private String workDays;
    //private List<DayOfWeek> workDays;
    //Que solo exista en ProfesionaService y aca se elimina
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;
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

    public Professional(String name, String lastName, String cuil, LocalTime initWorkHour, LocalTime endWorkHour, String workDays, List<Appointment> appointments, List<Specialty> specialties) {
        this.name = name;
        this.lastName = lastName;
        this.cuil = cuil;
        this.initWorkHour = initWorkHour;
        this.endWorkHour = endWorkHour;
        this.workDays = workDays;
        this.appointments = appointments;
        this.specialties = specialties;
    }

    public Professional(String userName, String userPass, Contact contact, String name, String lastName, String cuil, LocalTime initWorkHour, LocalTime endWorkHour, String workDays, List<Appointment> appointments, List<Specialty> specialties) {
        super(userName, userPass, contact);
        this.name = name;
        this.lastName = lastName;
        this.cuil = cuil;
        this.initWorkHour = initWorkHour;
        this.endWorkHour = endWorkHour;
        this.workDays = workDays;
        this.appointments = appointments;
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

    public LocalTime getInitWorkHour() {
        return initWorkHour;
    }

    public void setInitWorkHour(LocalTime initWorkHour) {
        this.initWorkHour = initWorkHour;
    }

    public LocalTime getEndWorkHour() {
        return endWorkHour;
    }

    public void setEndWorkHour(LocalTime endWorkHour) {
        this.endWorkHour = endWorkHour;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public List<Appointment> getPlanners() {
        return appointments;
    }

    public void setPlanners(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
