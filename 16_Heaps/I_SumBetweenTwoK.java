//https://youtu.be/3ioQQQrnw4Q?si=TjAlLwZgic0F8I40
//https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
//Explanation: Find sum of elements between k1th smallest element and k2th smallest element.

import java.util.Collections;
import java.util.PriorityQueue;

public class I_SumBetweenTwoK {
    public static void main(String[] args) {
        //long[] A = new long[]{20, 8, 22, 4, 12, 10, 14};
        long[] A = new long[]{10, 2, 50, 12, 48, 13};
        long K1 = 2;
        long K2 = 6;
        long N = A.length;
        long result = sumBetweenTwoKth(A, N, K1, K2);
        System.out.println(result);
    }

    private static long sumBetweenTwoKth(long[] A, long N, long K1, long K2){
        long sum = 0;
        long element1 = getKSmallestElement(A, K1);
        long element2 = getKSmallestElement(A, K2);

        for(int i=0; i<A.length; i++){
            if(A[i] > element1 && A[i] < element2){
                sum = sum + A[i];
            }
        }

        return sum;
    }

    private static long getKSmallestElement(long[] A, long K){
        PriorityQueue<Long> maxHeap =  new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<A.length; i++){
            maxHeap.add(A[i]);
            if(maxHeap.size() > K){
                maxHeap.remove();
            }
        }
        return maxHeap.remove();
    }
}