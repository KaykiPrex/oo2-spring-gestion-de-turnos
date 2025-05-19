package com.unla.grupo18.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "work_email")
    private String workEmail;
    @Column(name = "personal_email")
    private String personalEmail;
    private String phone;
    private String mobile;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Contact() {
    }

    public Contact(int id, String workEmail, String personalEmail, String phone, String mobile, User user) {
        this.id = id;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.phone = phone;
        this.mobile = mobile;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
