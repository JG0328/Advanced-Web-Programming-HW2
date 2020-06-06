package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Receipt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String returnDate;
    @OneToOne
    private Client client;
    @OneToMany
    private Set<EquipmentRental> equipmentRental;
    private float cost;
    private int days;
    private Boolean pending;

    public Receipt() {
    }

    public Receipt(Date date, String returnDate, Client client, Set<EquipmentRental> equipmentRental, float cost,
                   int days, Boolean pending) {
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

    public void setId(int uuid) {
        this.id = uuid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }
}
