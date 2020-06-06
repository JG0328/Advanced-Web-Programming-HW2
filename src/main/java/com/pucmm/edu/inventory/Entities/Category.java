package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne
    private Category parentCategory;
    private String description;
    private boolean isActive;

    public Category() {

    }

    public Category(String name, Category parentCategory, String description, boolean isActive) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.description = description;
        this.isActive = isActive;
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category category) {
        this.parentCategory = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
