package com.example.solomobile.data.model;

public class Car {
    private String title;
    private String currentBid;
    private String timeRemaining;
    private int imageResId;

    public Car(String title, String currentBid, String timeRemaining, int imageResId) {
        this.title = title;
        this.currentBid = currentBid;
        this.timeRemaining = timeRemaining;
        this.imageResId = imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentBid() {
        return currentBid;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }
}