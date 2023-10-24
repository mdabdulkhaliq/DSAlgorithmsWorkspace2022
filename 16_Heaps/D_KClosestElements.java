//https://youtu.be/J8yLD-x7fBI?si=ph87d-QNfWJtFczW
//https://leetcode.com/problems/find-k-closest-elements/
//Explanation: In order to find K closest element to a number X, the difference between the element and X should be minimum. So we need elements with min difference, so create a maxHeap and store the difference and the element as a pair by maintaining a heap size of K. once all elements are added to heap, the elements in the heap of size K will be the closest elements to X.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class D_KClosestElements {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 16, 22, 30, 31, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;
        List<Integer> l = findKClosestElements(arr, arr.length, k, x);
        for(int e: l){
            System.out.println(e + " ");
        }
    }

    private static List<Integer> findKClosestElements(int[] arr, int n, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        while(maxHeap.size() > 0){
            result.add(maxHeap.remove().getElement());
        }

        //Collections.sort(result);
        return result;
    }

    static class Pair implements Comparable<Pair>{
        int difference;
        int element;

        Pair(int difference, int element){
            this.difference = difference;
            this.element = element;
        }

        int getDifference(){
            return this.difference;
        }

        int getElement(){
            return element;
        }

        public int compareTo(Pair o)
        {
            if(difference - o.difference == 0){
                return element - o.element;
            } else {
                return difference - o.difference;
            }
        }
}
}


