package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineSegmentTest {

    @Test
    public void subDivide() {
        Point[] pointsExpected = new Point[2];
        pointsExpected[0]= new Point(1,1); pointsExpected[1]= new Point(2,2);
        Point point1 = new Point(0,0);
        Point point2 = new Point(3,3);
        LineSegment lineSegment = new LineSegment(point1, point2);
        Point[] pointsActual = lineSegment.subDivide(3);
            for (int i = 0; i <pointsActual.length ; i++) {

                assertEquals(pointsExpected[i].getX(),pointsActual[i].getX(),0.000001);
                assertEquals(pointsExpected[i].getY(),pointsActual[i].getY(),0.000001);
        }
    }

    @Test
    public void interpolate() {
        Point a = new Point(1,1);
        Point b = new Point(4,5);
        LineSegment ls = new LineSegment(a,b);
        Point pointActual = ls.interpolate(2);
        Point pointExpected = new Point(2.2,2.6);

        assertEquals(pointActual.getX(),pointExpected.getX(),.0001);
        assertEquals(pointActual.getY(),pointExpected.getY(),.0001);
    }
}