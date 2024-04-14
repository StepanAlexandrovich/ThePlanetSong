package org.example.core;

import java.util.ArrayList;
import java.util.List;

public class NumbersSmooth {
    private Numbers numbers;
    private int length;
    private int step = 0;
    public NumbersSmooth(Numbers numbers, int length) {
        this.numbers = numbers;
        this.length = length;
    }
    public void process(){
        if(++step == length){
            step = 0;
            numbers.process();
        }
    }
    public boolean beat(){ return step == 0; }
    public int getValue(){ return numbers.getValue(); }
    public List<PointSmooth> getPointSmooths(){
        List<Point> points = numbers.getPoints();
        List<PointSmooth> pointSmooths = new ArrayList<>();

        for (Point point : points) {
            double distance1 = point.getDistanceNow();
            double distance2 = point.getSpeed() * ( (double)step/(double)length );

            PointSmooth pointSmooth = new PointSmooth();
            pointSmooth.setDistance(distance1 + distance2);
            pointSmooth.setSpeed(point.getSpeed());

            pointSmooths.add(pointSmooth);
        }
        return pointSmooths;
    }
}
