package com.unla.grupo18.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String pass;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Contact contact;

    public User() {
    }

    public User(Contact contact, String pass, String name, int id) {
        this.contact = contact;
        this.pass = pass;
        this.name = name;
        this.id = id;
    }

    public User(String name, String pass, Contact contact) {
        this.name = name;
        this.pass = pass;
        this.contact = contact;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
