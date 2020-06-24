package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceFromOrigin() {

        assertEquals("Quadrant 1",new Point(3,4).getQuadrant());
        assertEquals("Quadrant 2",new Point(-4.5,6).getQuadrant());
        assertEquals("Quadrant 3",new Point(-1,-1).getQuadrant());
        assertEquals("Quadrant 4",new Point(19,-3.2215).getQuadrant());
        assertEquals("Axes",new Point(0,-7).getQuadrant());
        assertEquals("Axes",new Point(12,0).getQuadrant());
        assertEquals("Axes",new Point(0,0).getQuadrant());






    }

    @Test
    public void getQuadrant() {




    }

    @Test
    public void distanceToPoint() {
        Point a = new Point (1,1);
        Point b = new Point (6,13);
        assertEquals(13, a.distanceToPoint(b),.000001);
    }
    @Test
    public void closestPoint() {
        Point[] points = new Point[]{new Point(1,1), new Point(2,2), new Point(3,3)};
        Point a = new Point(4,4);

        Point closestPoint = a.closestPoint(points);

        assertEquals(3, closestPoint.getX(),.00001);
        assertEquals(3,closestPoint.getY(), .00001);
    }

    @Test
    public void distanceBetweenTwoPoints() {
        Point a = new Point(1,1);
        Point b = new Point(4,5);
        assertEquals(5, Point.distanceBetweenTwoPoints(a,b), .00001);
    }

    @Test
    public void midPoint() {
        Point a = new Point(1,1);
        Point b = new Point(4,5);
        Point midPointActual = Point.midPoint(a,b);
        assertEquals(2.5, midPointActual.getX(), .0001);
        assertEquals(3, midPointActual.getY(), .0001);

    }
}