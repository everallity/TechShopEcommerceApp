package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;

public class PhoneSpecs implements Serializable {
    private int id;
    private String size,display,weight,battery,connection,processor,camera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
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

    public PhoneSpecs(int id, String size, String display, String weight, String battery, String connection, String processor, String camera) {
        this.id = id;
        this.size = size;
        this.display = display;
        this.weight = weight;
        this.battery = battery;
        this.connection = connection;
        this.processor = processor;
        this.camera = camera;
    }

    public PhoneSpecs() {
    }

    @Override
    public String toString() {
        return "PhoneSpecs{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", display='" + display + '\'' +
                ", weight='" + weight + '\'' +
                ", battery='" + battery + '\'' +
                ", connection='" + connection + '\'' +
                ", processor='" + processor + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
