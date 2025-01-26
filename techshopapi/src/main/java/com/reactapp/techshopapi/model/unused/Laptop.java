package com.reactapp.techshopapi.model.unused;

import com.reactapp.techshopapi.model.Product;

import java.io.Serializable;
import java.util.List;

public class Laptop extends Product implements Serializable {
    private String cpu,gpu,ram,storage,battery,display,weight;
    private int laptop_id;

    public Laptop() {
    }

    public Laptop(String cpu, String gpu, String ram, String storage, String battery, String display, String weight, int laptop_id) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.battery = battery;
        this.display = display;
        this.weight = weight;
        this.laptop_id = laptop_id;
    }


    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
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

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", battery='" + battery + '\'' +
                ", display='" + display + '\'' +
                ", weight='" + weight + '\'' +
                ", laptop_id=" + laptop_id +
                '}';
    }
}
