package com.example.wendt.listexample;

/**
 * Created by per6 on 9/27/17.
 */

public class CoolGuy {
    private String name;
    private String description;
    private int imgResourceID;

    public CoolGuy(String name, String description, int imgResourceID) {
        this.name = name;
        this.description = description;
        this.imgResourceID = imgResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgResourceID() {
        return imgResourceID;
    }

    public void setImgResourceID(int imgResourceID) {
        this.imgResourceID = imgResourceID;
    }
}
