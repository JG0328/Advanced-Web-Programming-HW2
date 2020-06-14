package com.pucmm.edu.inventory.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class Image implements Serializable {
    @Id
    @GeneratedValue
    int id;
    String name;
    String mimeType;
    @Lob
    String base64Image;

    public Image(String name, String mimeType, String base64Image) {
        this.name = name;
        this.mimeType = mimeType;
        this.base64Image = base64Image;
    }

    public Image(){

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

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
