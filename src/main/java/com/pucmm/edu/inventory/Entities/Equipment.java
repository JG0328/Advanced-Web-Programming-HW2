package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue
    private String uuid;
    private String name;
    private long rate;
    @OneToOne
    private Category category;
    @OneToOne
    private Category subCategory;
    private boolean isActive;
    private int days;
    private int stock;
    private String image;

    public Equipment() {

    }

    public Equipment(String name, long rate, Category category, Category subCategory, boolean isActive, int days,
            int stock, String image) {
        this.name = name;
        this.rate = rate;
        this.category = category;
        this.subCategory = subCategory;
        this.isActive = isActive;
        this.days = days;
        this.stock = stock;
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
