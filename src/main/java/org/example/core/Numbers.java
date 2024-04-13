package org.example.core;

public class Numbers {
    // static
    private int distance;
    private int countOfPoints;
    private Point[] points = new Point[0];
    // dynamic
    private double multiplicationHz;
    private String mode = "";
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
        this.points = new Point[countOfPoints];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(3);
            points[i].setDistanceCircle(distance);
            points[i].setDistanceNow(0);
            points[i].setIndex(i);
            points[i].setSpeed(i);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public int[] getDistances(){
        int[] values = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            values[i] = (int) points[i].getDistanceNow();
        }
        return values;
    }
    public void process(){
        for (Point point : points) {
            point.process();
        }
    }

    public double getValue(){
        double result = 0;

        switch (mode){
            case "BORDER_UP": result = getValueUp(); break;
            case "BORDER_DOWN": result = getValueDown(); break;
        }
        return borderDown(result)*multiplicationHz;
    }
    private double getValueDown(){
        for (Point point : points) {
            if(point.getSpeed()!=0 && point.getDistanceNow() == 0.0){
                return point.getSpeed();
            }
        }
        return 0;
    }
    private double getValueUp(){
        double result = 0;
        for (Point point : points) {
            if(point.getSpeed()!=0 && point.getDistanceNow() == 0.0){
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
