package Array;


import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Arrays;

public class PointsBetweenRings {
    public int[] countPoints(int[] radius, Point[] points){
        int[] res = new int[radius.length];
        //how to implement sort for object
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.distance<p2.distance){
                    return -1;
                }else if(p1.distance>p2.distance){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        for(int i=0; i<points.length;i++){
            if(points[i].distance< radius[0]){
                res[0]++;
            }else if(points[i].distance>radius[radius.length-1]){
                res[radius.length-1]++;
            }else{
                res[getSmallestLarger(radius,points[i].distance)]++;
            }
        }
        return res;
    }
    //This is to assume more points than radius
    private int getSmallestLarger(int[] radius, double target) {
        int left= 0;
        int right = radius.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(radius[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        if(radius[left]>target){
            return left;
        } else{
            return left+1;
        }
    }
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        double distance;
        Point(int x, int y){
            this.x=x;
            this.y=y;
            this.distance=Math.sqrt(y*y+x*x);
        }
        @Override
        public int compareTo(@NotNull Point that) {
            return this.distance-that.distance>0? 1:-1;
        }
    }

    public static void main(String[] args) {
        Point p1= new Point(1,1);
        System.out.println(p1.distance);
        Point p2= new Point(1,2);
        System.out.println(p2.distance);
        Point p3= new Point(3,5);
        System.out.println(p3.distance);
        Point p4 = new Point(4,4);
        System.out.println(p4.distance);
        Point[] points= {p1,p2,p3,p4};
        int[] radius ={1,3,5};
        PointsBetweenRings solution = new PointsBetweenRings();
        int[] res = solution.countPoints(radius,points);// 0 1 3
        for(int i: res){
            System.out.println(i);
        }
    }
}
