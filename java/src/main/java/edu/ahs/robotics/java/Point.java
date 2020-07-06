package edu.ahs.robotics.java;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //public double distanceFromOrigin(){
    //    return 1.5;
    //}
    public double distanceFromOrigin() {
        double distance = Math.pow(x * x + y * y, .5);
        return distance;
    }

    public String getQuadrant() {
        if (x > 0 && y > 0) {
            return "Quadrant 1";
        } else if (x < 0 && y > 0) {
            return "Quadrant 2";
        } else if (x < 0 && y < 0) {
            return "Quadrant 3";
        } else if (x > 0 && y < 0) {
            return "Quadrant 4";
        } else if (x == 0 || y == 0) {
            return "Axes";
        } else {
            return null;
        }
    }



    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToPoint(Point other) {
        double deltaA = x - other.getX();
        double deltaB = y - other.getY();
        double distance = Math.sqrt(deltaA * deltaA + deltaB * deltaB);
        return distance;
    }

    public Point closestPoint(Point[] points) {
        Point closestPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            if (this.distanceToPoint(points[i]) < this.distanceToPoint(closestPoint)) {
                closestPoint = points[i];
            }
        }
        return closestPoint;
    }

    public static double distanceBetweenTwoPoints(Point a, Point b) {
        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();
        double distanceBetweenTwoPoints = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        return distanceBetweenTwoPoints;
    }

    public static Point midPoint(Point a, Point b) {
        Point midPoint = new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
        return midPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
