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
    private long rate;
    @OneToOne
    private Category category;
    @OneToOne
    private Category subCategory;
    private boolean enabled;
    private int days;

    public Equipment() {
    }

    public Equipment(String name, long rate, Category category, Category subCategory, boolean enabled, int days) {
        this.name = name;
        this.rate = rate;
        this.category = category;
        this.subCategory = subCategory;
        this.enabled = enabled;
        this.days = days;
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
}
