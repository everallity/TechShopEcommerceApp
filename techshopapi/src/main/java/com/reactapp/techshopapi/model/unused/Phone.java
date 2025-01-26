package com.reactapp.techshopapi.model.unused;

import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.model.unused.PhoneSpecs;

import java.io.Serializable;
import java.util.List;

public class Phone extends Product implements Serializable {
    private String size,display,weight,battery,processor,camera;
    private int phone_id;

    public Phone(String size, String display, String weight, String battery, String processor, String camera, int phone_id) {
        this.size = size;
        this.display = display;
        this.weight = weight;
        this.battery = battery;
        this.processor = processor;
        this.camera = camera;
        this.phone_id = phone_id;
    }

    public Phone() {
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "size='" + size + '\'' +
                ", display='" + display + '\'' +
                ", weight='" + weight + '\'' +
                ", battery='" + battery + '\'' +
                ", processor='" + processor + '\'' +
                ", camera='" + camera + '\'' +
                ", phone_id=" + phone_id +
                '}';
    }
}
