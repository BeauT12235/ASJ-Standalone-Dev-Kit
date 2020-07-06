package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void totalDistance() {

        Point[] points2 = new Point[]{new Point(0, 0), new Point(3, 4)};
        Path path2 = new Path(points2);
        assertEquals(5, path2.totalDistance(), .00001);

        Point[] points3 = new Point[]{new Point(0, 0), new Point(1, 1)};
        Path path3 = new Path(points3);
        assertEquals(Math.sqrt(2), path3.totalDistance(), .00001);

        Point[] points4 = new Point[]{new Point(0, 0), new Point(0, 0)};
        Path path4 = new Path(points4);
        assertEquals(0, path4.totalDistance(), .00001);

        Point[] points5 = new Point[]{new Point(0, 0), new Point(0, 5), new Point(5, 5)};
        Path path5 = new Path(points5);
        assertEquals(10, path5.totalDistance(), .00001);
    }

    @Test
    public void illegalArgumentExceptionTest() {
        Point[] points = new Point[]{new Point(3, 4)};
        Path path = new Path(points);
        assertEquals(0, path.totalDistance(), 0.00001);
    }

    @Test
    public void testRemoveDuplicates() {
        Point[] points = new Point[]{new Point(0, 0), new Point(3, 4), new Point(3, 4), new Point(5, 5)};
        Path path = new Path(points);
        Point[] pointsExpected = new Point[]{new Point(0, 0), new Point(3, 4), new Point(5, 5)};

        for (int i = 0; i < pointsExpected.length; i++) {
            assertEquals(pointsExpected[i], path.getWayPoints().get(i).point);
            if (i == 0) {
                assertEquals(0, path.getWayPoints().get(i).deltaXFromPrevious, .00001);
                assertEquals(0, path.getWayPoints().get(i).deltaYFromPrevious, .00001);
                assertEquals(0, path.getWayPoints().get(i).distanceFromPrevious, .00001);
            } else {
                assertEquals(pointsExpected[i].getX() - pointsExpected[i - 1].getX(), path.getWayPoints().get(i).deltaXFromPrevious, .00001);
                assertEquals(pointsExpected[i].getY() - pointsExpected[i - 1].getY(), path.getWayPoints().get(i).deltaYFromPrevious, .00001);
                assertEquals(Point.distanceBetweenTwoPoints(pointsExpected[i], pointsExpected[i - 1]), path.getWayPoints().get(i).distanceFromPrevious, .00001);
            }
        }
    }

    @Test
    public void targetPoint() {
        Point[] points = new Point[]{new Point(0,0), new Point(0,1), new Point(0,2)};
        Path path = new Path(points);
        Point targetPoint = new Point(0,1.5);
        assertEquals(targetPoint, interpolatedRemDist, .0001);
    }
}