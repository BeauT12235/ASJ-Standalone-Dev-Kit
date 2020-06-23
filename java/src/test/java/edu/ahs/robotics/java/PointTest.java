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


}