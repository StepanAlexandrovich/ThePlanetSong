package org.example.core;

public class Point extends NextValue {
    // dynamic
    private int[] distance;
    // static
    private Ring ring;
    private int index;
    private int speed = 0;

    public Point(int tableLength) {
        super(tableLength);

        distance = new int[tableLength];
        ring = new Ring();
    }

    // GET
    public int getIndex() { return index; }

    public int getDistanceBack() { return distance[back]; }
    public int getDistanceNow() {
        return distance[now];
    }
    public int getSpeed() { return speed; }

    // SET
    public void setIndex(int index) {
        this.index = index;
    }
    public void setDistanceNow(int distance) {
        this.distance[now] = distance;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setDistanceCircle(int distanceCircle) { ring.setStart(0).setEnd(distanceCircle - 1); }
    @Override
    public void nextValue() {
        distance[next] = ring.right(distance[now],speed);
    }
}
