package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void totalDistance() {

    }
    @Test
    public void testRemoveDuplicates() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4), new Point(3,4), new Point(5,5)};
        Path path = new Path(points);
        Point[] pointsExpected = new Point[] {new Point(0,0), new Point(3,4), new Point(5,5)};

        for (int i = 0; i < pointsExpected.length; i++) {
            assertEquals(pointsExpected[i], path.getWayPoints().get(i).point);
            if (i == 0){
                assertEquals(0,path.getWayPoints().get(i).deltaXFromPrevious,.00001);
                assertEquals(0,path.getWayPoints().get(i).deltaYFromPrevious,.00001);
                assertEquals(0,path.getWayPoints().get(i).distanceFromPrevious,.00001);
            }else {
                assertEquals(pointsExpected[i].getX()-pointsExpected[i-1].getX(),path.getWayPoints().get(i).deltaXFromPrevious,.00001);
                assertEquals(pointsExpected[i].getY()-pointsExpected[i-1].getY(),path.getWayPoints().get(i).deltaYFromPrevious,.00001);
                assertEquals(Point.distanceBetweenTwoPoints(pointsExpected[i],pointsExpected[i-1]),path.getWayPoints().get(i).distanceFromPrevious,.00001);
            }
        }
    }
}