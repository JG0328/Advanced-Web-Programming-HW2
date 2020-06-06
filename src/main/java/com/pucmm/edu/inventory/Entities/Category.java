package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @Column()
    private String uuid;
    private String name;
    @OneToOne
    private Category category;
    private String description;
    private boolean isActive;

    public Category() {

    }

    public Category(String name, Category category, String description, boolean isActive) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.isActive = isActive;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
