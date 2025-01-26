package com.reactapp.techshopapi.model;

import java.io.Serializable;

public class ClientStat extends Client implements Serializable {
    private int numberoftransaction;
    private float revenue;

    public ClientStat() {
    }

    public ClientStat(int numberoftransaction, float revenue) {
        this.numberoftransaction = numberoftransaction;
        this.revenue = revenue;
    }

    public ClientStat(int client_id, int account_id, String name, String address, String phone, String gender, String dob) {
        super(client_id, account_id, name, address, phone, gender, dob);
    }

    public ClientStat(int client_id, int account_id, String name, String address, String phone, String gender, String dob, int numberoftransaction, float revenue) {
        super(client_id, account_id, name, address, phone, gender, dob);
        this.numberoftransaction = numberoftransaction;
        this.revenue = revenue;
    }

    public int getNumberoftransaction() {
        return numberoftransaction;
    }

    public void setNumberoftransaction(int numberoftransaction) {
        this.numberoftransaction = numberoftransaction;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "ClientStat{" +
                "numberoftransaction=" + numberoftransaction +
                ", revenue=" + revenue +
                '}';
    }
}
