//https://youtu.be/_k_c9nqzKN0?si=dZaoHoPNaMvXzwjm
//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
//Problem: There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes. 
//Explanation: Cost to adding all ropes will be minimum if we add min rope lengths. Add all rope-lengths (elements) to a min heap and retrieve two ropes at a time and add them. the sum of two ropes should be added back to the min heap and also to the total cost (no. of additions). Finally return total cost

import java.util.PriorityQueue;

public class H_ConnectRopes {
    public static void main(String[] args) {
        long[] arr = new long[]{4, 3, 2, 6};
        long cost = minCost(arr, arr.length);
        System.out.println(cost);
    }

    private static long minCost(long arr[], int n){
        long cost  = 0;
        
        //Add all rope lengths to the min heap
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            minHeap.add(arr[i]);
        }

        //Retrieve two minimum rope lengths from the heap
        while(minHeap.size() > 1){
            long firstElement = minHeap.remove();
            long secondElement = minHeap.remove();
            //new rope size and also the cost of adding these 2 ropes
            long currentCost = firstElement + secondElement;
            //add the new rope size back to heap
            minHeap.add(currentCost);
            //add to total cost of operations
            cost = cost + currentCost;
        }

        return cost;
    }
}
