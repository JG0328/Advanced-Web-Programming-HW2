package com.pucmm.edu.inventory.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Equipment {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float rate;
    @OneToOne
    private Category category;
    private boolean enabled;
    private int days;
    private String photo;
    private int stock;
    private int stockRent;

    public Equipment() {
    }

    public Equipment(String name, float rate, Category category, boolean enabled, String photo, int stock, int stockRent) {
        this.name = name;
        this.rate = rate;
        this.category = category;
        this.enabled = enabled;
        this.photo = photo;
        this.stock = stock;
        this.stockRent = stockRent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockRent() {
        return stockRent;
    }

    public void setStockRent(int stockRent) {
        this.stockRent = stockRent;
    }
}
