package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;

public class PrebuiltPCSpecs implements Serializable {
    private int id;
    private String Case,main,op_System,processor,cooling,memory,board,storage,card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String aCase) {
        Case = aCase;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getOp_System() {
        return op_System;
    }

    public void setOp_System(String op_System) {
        this.op_System = op_System;
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

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public PrebuiltPCSpecs(int id, String aCase, String main, String op_System, String processor, String cooling, String memory, String board, String storage, String card) {
        this.id = id;
        Case = aCase;
        this.main = main;
        this.op_System = op_System;
        this.processor = processor;
        this.cooling = cooling;
        this.memory = memory;
        this.board = board;
        this.storage = storage;
        this.card = card;
    }

    public PrebuiltPCSpecs() {
    }

    @Override
    public String toString() {
        return "PrebuiltPCSpecs{" +
                "id=" + id +
                ", Case='" + Case + '\'' +
                ", main='" + main + '\'' +
                ", op_System='" + op_System + '\'' +
                ", processor='" + processor + '\'' +
                ", cooling='" + cooling + '\'' +
                ", memory='" + memory + '\'' +
                ", board='" + board + '\'' +
                ", storage='" + storage + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
