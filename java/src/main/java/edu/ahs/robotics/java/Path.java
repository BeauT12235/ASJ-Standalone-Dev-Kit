package edu.ahs.robotics.java;

public class Path {

    /**
     * @param rawPoints Array of X,Y points.  Duplicate points are discarded
     *                  A path must have at least 2 non-identical points
     */
    public double Path(Point[] rawPoints) {



    }
        /**
         * @return total distance of the path
         */
        public double totalDistance(){
            return 0.0;
        }
        /**
         * @return a point at the supplied distance along the path from the supplied current position
         * Note that the point will usually be interpolated between the points that originally defined the Path
         */
        public Path.WayPoint targetPoint(Point current, double distance) {
            return new WayPoint(new Point(0,0));
        }

    }





}
