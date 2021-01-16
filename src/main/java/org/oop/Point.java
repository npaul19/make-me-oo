package org.oop;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double calculateDiffInXWRT(Point p) {
        return p.x - this.x;
    }

    private double calculateDiffInYWRT(Point p) {
        return p.y - this.y;
    }

    public double distanceFrom(Point p) {
        return Math.sqrt(Math.pow(calculateDiffInXWRT(p), 2) + Math.pow(calculateDiffInYWRT(p), 2));
    }

    public double directionWRT(Point p) {
        return Math.atan2(calculateDiffInYWRT(p), calculateDiffInXWRT(p));
    }

}
