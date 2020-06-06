package com.pucmm.edu.inventory.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EquipmentRental {
    @Id
    @GeneratedValue()
    private int id;
    @OneToOne
    private Equipment equipment;
    private int numberRented;
    private int days;
    private float cost;
    private boolean isReturned;

    public EquipmentRental() {
    }

    public EquipmentRental(Equipment equipment, int numberRented, int days, float cost, boolean isReturned) {
        this.equipment = equipment;
        this.numberRented = numberRented;
        this.days = days;
        this.cost = cost;
        this.isReturned = isReturned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getNumberRented() {
        return numberRented;
    }

    public void setNumberRented(int numberRented) {
        this.numberRented = numberRented;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
