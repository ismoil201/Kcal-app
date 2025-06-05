package com.ismoil.kcal;

public class Food {

    int image;
    String name;
    String bio;
    String kCal;


    public Food(int image, String name, String bio, String kCal) {
        this.image = image;
        this.name = name;
        this.bio = bio;
        this.kCal = kCal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getkCal() {
        return kCal;
    }

    public void setkCal(String kCal) {
        this.kCal = kCal;
    }
}
