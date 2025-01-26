package com.reactapp.techshopapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "Account")
public class Account implements Serializable {
    @Column(name="Username")
    private String username;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;
    @Id
    @Column(name="Account_id")
    private int id;
    @Column(name = "Type")
    private int type;

    public Account(String username, String email, String password, int id, int type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Account() {
    }

    public Account(String username, String email, String password, int id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
