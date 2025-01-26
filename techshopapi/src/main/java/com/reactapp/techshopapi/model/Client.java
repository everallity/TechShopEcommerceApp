package com.reactapp.techshopapi.model;

import javax.persistence.*;
import java.io.Serializable;
public class Client implements Serializable {
   private int client_id;
   private int account_id;
   private String name,address,phone,gender,dob;

    public Client() {
    }

    public Client(int client_id, int account_id, String name, String address, String phone, String gender, String dob) {
        this.client_id = client_id;
        this.account_id = account_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", account_id=" + account_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
