package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;

public class LaptopSpecs implements Serializable {
    private int id;
    private String CPU,GPU,RAM,Storage,battery,display,weight,camera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
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

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public LaptopSpecs(int id, String CPU, String GPU, String RAM, String storage, String battery, String display, String weight, String camera) {
        this.id = id;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        Storage = storage;
        this.battery = battery;
        this.display = display;
        this.weight = weight;
        this.camera = camera;
    }

    public LaptopSpecs() {
    }

    @Override
    public String toString() {
        return "LaptopSpecs{" +
                "id=" + id +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", Storage='" + Storage + '\'' +
                ", battery='" + battery + '\'' +
                ", display='" + display + '\'' +
                ", weight='" + weight + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
