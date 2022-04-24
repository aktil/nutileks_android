package com.example.doctors;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String name;
    private String room;
    private String speciality;
    private int imageView;

    public Doctor(String name, String room, String speciality, int imageView) {
        this.name = name;
        this.room = room;
        this.speciality = speciality;
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
