package com.reactapp.techshopapi.model.unused;


import com.reactapp.techshopapi.model.Product;

import java.io.Serializable;
import java.util.List;

public class Console extends Product implements Serializable   {
    private String cpu,gpu,ram,storage;
    private int console_id;

    public Console() {
    }

    public Console(String cpu, String gpu, String ram, String storage, int console_id) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.console_id = console_id;
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

    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    @Override
    public String toString() {
        return "Console{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", console_id=" + console_id +
                '}';
    }
}
