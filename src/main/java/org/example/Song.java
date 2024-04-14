package org.example;

public class Song {
    private int id;
    private int lengthCycle;
    private int countOfPoints;
    private String mode = "DOWN";
    private int borderDown;
    private double multiplicationHz;
    private int volume;
    private int durationSound;
    private long delayCycle;

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
    public int getDurationSound() { return durationSound; }
    public void setDurationSound(int durationSound) { this.durationSound = durationSound; }

    public long getDelayCycle() {
        return delayCycle;
    }

    public void setDelayCycle(int delayCycle) {
        this.delayCycle = delayCycle;
    }
}
