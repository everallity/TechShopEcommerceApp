package com.reactapp.techshopapi.model.unused;

import com.reactapp.techshopapi.model.Product;
import com.reactapp.techshopapi.model.unused.PrebuiltPCSpecs;

import java.io.Serializable;
import java.util.List;

public class PC extends Product implements Serializable {
    private String pccase,motherboard,opsys,processor,cooling,memory,gcard,storage;
    private int pc_id;

    public PC() {
    }

    public PC(String pccase, String motherboard, String opsys, String processor, String cooling, String memory, String gcard, String storage, int pc_id) {
        this.pccase = pccase;
        this.motherboard = motherboard;
        this.opsys = opsys;
        this.processor = processor;
        this.cooling = cooling;
        this.memory = memory;
        this.gcard = gcard;
        this.storage = storage;
        this.pc_id = pc_id;
    }


    public String getPccase() {
        return pccase;
    }

    public void setPccase(String pccase) {
        this.pccase = pccase;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getOpsys() {
        return opsys;
    }

    public void setOpsys(String opsys) {
        this.opsys = opsys;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGcard() {
        return gcard;
    }

    public void setGcard(String gcard) {
        this.gcard = gcard;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getPc_id() {
        return pc_id;
    }

    public void setPc_id(int pc_id) {
        this.pc_id = pc_id;
    }

    @Override
    public String toString() {
        return "PC{" +
                "pccase='" + pccase + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", opsys='" + opsys + '\'' +
                ", processor='" + processor + '\'' +
                ", cooling='" + cooling + '\'' +
                ", memory='" + memory + '\'' +
                ", gcard='" + gcard + '\'' +
                ", storage='" + storage + '\'' +
                ", pc_id=" + pc_id +
                '}';
    }
}
