package com.pucmm.edu.inventory.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int uuid;

    private String date;

    private Date returnDate;

    @OneToOne
    private  Client client;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<EquipRental> equipRental;

    private float cost;

    public int getDiasRent() {
        return diasRent;
    }

    public void setDiasRent(int diasRent) {
        this.diasRent = diasRent;
    }

    private int diasRent;

    private Boolean pending;
}
