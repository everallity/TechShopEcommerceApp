package com.reactapp.techshopapi.model;

import javax.persistence.*;
import java.io.Serializable;
public class Staff implements Serializable {
    private int account_id;
    private int staff_id;
    private float salary;
    private String name,address,dob,position,phone,gender;

    public Staff() {
    }

    public Staff(int account_id, int staff_id, float salary, String name, String address, String dob, String position, String phone, String gender) {
        this.account_id = account_id;
        this.staff_id = staff_id;
        this.salary = salary;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.position = position;
        this.phone = phone;
        this.gender = gender;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "Staff{" +
                "account_id=" + account_id +
                ", staff_id=" + staff_id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
