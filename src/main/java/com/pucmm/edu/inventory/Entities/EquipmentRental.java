package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EquipmentRental implements Serializable {
    @Id
    @GeneratedValue()
    @Column()
    private String uuid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
