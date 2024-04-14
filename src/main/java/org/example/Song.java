package org.example;

public class Song {
    private int id;
    private int lengthCycle;
    private int countOfPoints;
    private String mode = "DOWN";
    private int borderDown;
    private double multiplicationHz;
    private int volume;
    private int speed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLengthCycle() {
        return lengthCycle;
    }

    public void setLengthCycle(int lengthCycle) {
        this.lengthCycle = lengthCycle;
    }

    public int getCountOfPoints() {
        return countOfPoints;
    }

    public void setCountOfPoints(int countOfPoints) {
        this.countOfPoints = countOfPoints;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getBorderDown() {
        return borderDown;
    }

    public void setBorderDown(int borderDown) {
        this.borderDown = borderDown;
    }

    public double getMultiplicationHz() {
        return multiplicationHz;
    }

    public void setMultiplicationHz(double multiplicationHz) {
        this.multiplicationHz = multiplicationHz;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
