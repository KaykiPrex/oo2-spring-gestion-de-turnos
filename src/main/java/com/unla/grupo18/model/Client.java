package com.unla.grupo18.model;

import jakarta.persistence.*;
import com.unla.grupo18.model.User;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends User{
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String dni;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Client() {
    }

    public Client(String name, String lastName, String dni, List<Appointment> appointments) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.appointments = appointments;
    }

    public Client(String username, String password, String name, String lastName, String dni){
        super(username, password, null);
        this.name=name;
        this.lastName= lastName;
        this.dni= dni;
    }
    public Client(String userName, String userPass, Contact contact, String name, String lastName, String dni, List<Appointment> appointments) {
        super(userName, userPass, contact);
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.appointments = appointments;
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

    public String getDni() {
        return dni;
    }

    public int getUserId(){return super.getId();}

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
