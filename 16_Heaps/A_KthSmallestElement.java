//https://youtu.be/4BfL2Hjvh8g?si=A2uw158GsizNJKvQ
//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Since Kth smallest is asked, create a max heap so that max elements are on top of stack. Maintain the size of the stack to k elements so that top k-1 elements are removed in the heap and the element left on top of the stack will be the kth smallest element
//Time complextity O(nlogk) since we are only sorting k elements in the heap, space complex O(n)
//If we sort time complexity will be O(nlogn) since we sort all elements

import java.util.Collections;
import java.util.PriorityQueue;

public class A_KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{7,10,4,3,20,15};
        int k = 3;
        int result = findKthSmallest(arr, k);
        System.out.println(result);
    }

    private static int findKthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        return maxHeap.peek();
    }

}