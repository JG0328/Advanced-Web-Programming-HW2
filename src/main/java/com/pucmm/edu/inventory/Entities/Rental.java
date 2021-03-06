package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Rental {
    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String returnDate;
    @OneToOne
    private Client client;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<EquipmentRental> equipmentRental;
    private float cost;
    private int days;
    private boolean pending;

    public Rental() {
    }

    public Rental(String date, String returnDate, Client client, Set<EquipmentRental> equipmentRental, float cost, int days, boolean pending) {
        this.date = date;
        this.returnDate = returnDate;
        this.client = client;
        this.equipmentRental = equipmentRental;
        this.cost = cost;
        this.days = days;
        this.pending = pending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<EquipmentRental> getEquipmentRental() {
        return equipmentRental;
    }

    public void setEquipmentRental(Set<EquipmentRental> equipmentRental) {
        this.equipmentRental = equipmentRental;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }
}
