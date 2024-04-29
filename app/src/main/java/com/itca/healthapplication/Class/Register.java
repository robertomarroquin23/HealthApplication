package com.itca.healthapplication.Class;

public class Register {
    private double distance;
        private int calories;

    public Register(double distance, int calories) {
        this.distance = distance;
        this.calories = calories;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
