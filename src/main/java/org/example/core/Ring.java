package org.example.core;

public class Ring{
    private int start,end;

    public Ring setStart(int start) {
        this.start = start;
        return this;
    }
    public Ring setEnd(int end) {
        this.end = end;
        return this;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int right(int coordinate,int distance){
        for (int i = 0; i < distance; i++) {
            coordinate = onRight(coordinate);
        }
        return coordinate;
    }
    public int left(int coordinate,int distance){
        for (int i = 0; i < distance; i++) {
            coordinate = onLeft(coordinate);
        }
        return coordinate;
    }
    public int distanceRight(int start,int end){
        int coordinate = start;
        int distance = 0;
        while (coordinate!=end){
            coordinate = onRight(coordinate);
            distance++;
        }
        return distance;
    }

    public int distanceLeft(int start,int end){
        int coordinate = start;
        int distance = 0;
        while (coordinate!=end){
            coordinate = onLeft(coordinate);
            distance++;
        }
        return distance;
    }

    public int onRight(int coordinate){
        if(++coordinate > end){
            coordinate = start;
        }
        return coordinate;
    }
    public int onLeft(int coordinate){
        if(--coordinate < start){
            coordinate = end;
        }
        return coordinate;
    }

}
