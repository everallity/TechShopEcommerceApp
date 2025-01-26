package com.reactapp.techshopapi.model.dto;

import java.io.Serializable;

public class LoginCredential implements Serializable {
    private String email,pw;
    private int type;

    public LoginCredential() {
    }

    public LoginCredential(String email, String pw, int type) {
        this.email = email;
        this.pw = pw;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public LoginCredential(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "LoginCredential{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", type=" + type +
                '}';
    }
}
