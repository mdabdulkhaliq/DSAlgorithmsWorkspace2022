//https://youtu.be/dYfM6J1y0mU?si=gIgYSCiT_k_xKK3b
//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
//Explanation: Given a K sorted or a nearly sorted array i.e an element at ith index will be at max in between i-k or i+k positions from it current position.
//Use a heap of size K, so that for every window of size K we will have the minimum element at the top for that window, use this to create a sorted array and continue this until all elements are sorted, finally clear the heap. This will reduce the complexity to O(nlogk) instead of O(nlogn) which requires sorting all elements.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class C_SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,3,2,8,10,9};
        ArrayList<Integer> result = nearlySorted(arr, arr.length, 3);
        for(int element: result){
            System.out.print(element + " ");
        }
    }

    private static ArrayList<Integer> nearlySorted(int arr[], int num, int k){
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<num; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                result.add(minHeap.remove());
            }
        }

        while(minHeap.size() > 0){
            result.add(minHeap.remove());
        }

        return result;
    }
}
