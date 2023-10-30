//https://youtu.be/XC4EotTewro?si=T3sHEqjdGg8XXUfJ
//https://leetcode.com/problems/k-closest-pointXs-to-origin/
//Explanation: In order to find K points closest to origin the distance between the origin 0,0 and point x,y should be minimum. Distance between two points is sqrt((x1-x2)^2 + (y1-y2)^2). Store this on a max heap of size k. Save a Pair with distance as first element and the point(x,y) as second element. This will become sqrt(x^2 + y^2) because the other point is origin 0,0. saving sqrt value or without sqrt value on maxHeap is same.

import java.util.Collections;
import java.util.PriorityQueue;

public class G_KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = new int[][]{{-5,4},{-6,-5},{4,6}};
        int[][] result = kClosest(points, 2);
        for(int[] ele: result){
            System.out.println(ele[0] + "," + ele[1]);
        }
    }

    private static int[][] kClosest(int[][] points, int k){
        //create a result array of size k and 2 columns as a point will have x,y
        int[][] result =  new int[k][2];
        
        //create a maxHeap to store the closest k points to origin
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //For all the points, calcuate the distance from origin and add to maxHeap
        //if size of maxHeap crosses K remove an element
        for(int i=0; i<points.length; i++){
            int distance = (int)(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
            maxHeap.add(new Pair(distance, points[i][0],points[i][1]));
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        
        //Remove all elements from maxHeap and add the X and Y value to the result array
        int l = 0;
        while(maxHeap.size() > 0){
            result[l][0] = maxHeap.peek().getPointX();
            result[l][1] = maxHeap.peek().getPointY();
            maxHeap.remove();
            l++;
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        int distance;
        int pointX;
        int pointY;

        Pair(int distance, int pointX, int pointY) {
            this.distance = distance;
            this.pointX = pointX;
            this.pointY = pointY;
        }

        int getDistance() {
            return this.distance;
        }

        int getPointX() {
            return pointX;
        }

        int getPointY() {
            return pointY;
        }

        public int compareTo(Pair o) {
            return distance - o.distance;
        }
    }
}