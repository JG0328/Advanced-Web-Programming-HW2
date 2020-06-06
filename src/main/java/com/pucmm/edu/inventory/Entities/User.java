package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private String uuid;
    private String user;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Role> rolSet;
    private boolean isActive;

    public User() {

    }

    public User(String user, String password, Set<Role> rolSet, boolean isActive) {
        this.user = user;
        this.password = password;
        this.rolSet = rolSet;
        this.isActive = isActive;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Role> rolSet) {
        this.rolSet = rolSet;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}