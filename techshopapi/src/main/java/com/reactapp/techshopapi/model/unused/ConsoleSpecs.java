package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;

public class ConsoleSpecs implements Serializable {
    private int id;
    private String CPU,GPU,RAM,Storage,video_output,sound_output;

    public ConsoleSpecs() {
    }

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

    public String getVideo_output() {
        return video_output;
    }

    public void setVideo_output(String video_output) {
        this.video_output = video_output;
    }

    public String getSound_output() {
        return sound_output;
    }

    public void setSound_output(String sound_output) {
        this.sound_output = sound_output;
    }

    public ConsoleSpecs(int id, String CPU, String GPU, String RAM, String storage, String video_output, String sound_output) {
        this.id = id;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        Storage = storage;
        this.video_output = video_output;
        this.sound_output = sound_output;
    }

    @Override
    public String toString() {
        return "ConsoleSpecs{" +
                "id=" + id +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", Storage='" + Storage + '\'' +
                ", video_output='" + video_output + '\'' +
                ", sound_output='" + sound_output + '\'' +
                '}';
    }
}
