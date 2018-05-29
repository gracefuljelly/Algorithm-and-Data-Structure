package HashMap;
/*
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
* */

import java.util.HashMap;

public class MostPointsonALine {

    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
     }

    public int maxPoints(Point[] points) {
        int result=0;
        //we use each pair of points to form a line
        for(int i=0; i<points.length;i++){
            //any line can be represented by a point and a slope.
            //we take the point as seed and try to find all possible slopes.
            Point seed = points[i];
            //record the points with same <x,y>;
            int same=1;
            //record the points with same
            int sameX=0;
            //record the maximum number of points on the same line crossing the seed point.
            int most=0;
            //a map with all possible slope
            HashMap<Double, Integer> cnt = new HashMap<>();
            for(int j=0; j<points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y) {
                    same++;
                } else if (tmp.x == seed.x) {
                    sameX++;
                } else {
//otherwise, just calculate the slope and increment the counter for the calculated slope
                    double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                    if (!cnt.containsKey(slope)) {
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, cnt.get(slope));
                    result = Math.max(result, most);
                }
            }
        }return result;
    }
}
