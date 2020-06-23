package edu.ahs.robotics.java;

public class Point {
    private double x;

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

    public double distanceFromOrigin(){
        double distance = Math.pow(x*x+y*y,.5);

        return distance;


    }

    public String getQuadrant() {
        if (x > 0 && y > 0) {
            return "Quadrant 1";
        } else if (x<0 && y>0){
            return "Quadrant 2";
        } else if (x<0 && y<0){
            return "Quadrant 3";
        } else if (x>0 && y<0){
            return "Quadrant 4";
        } else if (x==0 || y==0){
            return "Axes";
        }
        else {
            return null;
        }
    }



    private double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double distanceToPoint(Point other){
        double deltaA = x - other.getX();
        double deltaB = y - other.getY();
        double distance = Math.sqrt(deltaA*deltaA+deltaB*deltaB);
        return distance;

    }

    public Point closestPoint(Point[ ] points){
    Point point1 =
    }

}
