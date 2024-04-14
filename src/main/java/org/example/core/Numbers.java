package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    // static
    private int distance;
    private int countOfPoints;
    private List<Point> points = new ArrayList<>();
    // dynamic
    private double multiplicationHz;
    private String mode = "DOWN";
    private int borderDown;

    public Numbers setDistance(int distance) {
        this.distance = distance;
        return this;
    }
    public Numbers setCountOfPoints(int countOfPoints) {
        this.countOfPoints = countOfPoints;
        return this;
    }

    public Numbers setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public Numbers setBorderDown(int borderDown) {
        this.borderDown = borderDown;
        return this;
    }

    public Numbers setMultiplicationHz(double multiplicationHz) {
        this.multiplicationHz = multiplicationHz;
        return this;
    }

    public void apply(){
        this.points = new ArrayList<>();
        for (int speed = 1; speed < distance; speed++) {

            if(distance%speed == 0){
                Point point = new Point(3);

                point.setDistanceCircle(distance);
                point.setSpeed(speed);
                point.setDistanceNow(0);
                point.setIndex(speed);

                points.add(point);
            }

        }
    }
    public List<Point> getPoints() {
        return points;
    }

    public void process(){
        for (Point point : points) {
            point.process();
        }
    }

    public int getValue(){
        int result = 0;

        switch (mode){
            case "UP": result = getValueUp(); break;
            case "DOWN": result = getValueDown(); break;
        }
        return (int)((double)borderDown(result)*multiplicationHz);
    }
    private int getValueDown(){
        for (Point point : points) {
            if(point.getSpeed()!=0 && point.getDistanceNow() == 0){
                return point.getSpeed();
            }
        }
        return 0;
    }
    private int getValueUp(){
        int result = 0;
        for (Point point : points) {
            if(point.getSpeed()!=0 && point.getDistanceNow() == 0){
                result = point.getSpeed();
            }
        }
        return result;
    }
    private double borderDown(double value){
        while (value<borderDown && value!=0){
            value*=2;
        }
        return value;
    }

}
