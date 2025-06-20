package com.unla.grupo18.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "professional_service")
public class ProfessionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal price;
    @Column(name = "init_work_hour")
    private LocalTime initWorkHour;
    @Column(name = "end_work_hour")
    private LocalTime endWorkHour;
    @Column(name = "work_days")
    private String workDays;
    //private List<DayOfWeek> workDays;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @OneToMany(mappedBy = "professionalService")
    private List<Appointment> appointments;

    public ProfessionalService() {
    }
    public ProfessionalService(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public ProfessionalService(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
