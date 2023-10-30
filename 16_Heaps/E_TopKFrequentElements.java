//https://youtu.be/7VoJn544QrM?si=RAHOPKbYrB_TfI9f
//https://leetcode.com/problems/top-k-frequent-elements/
//Explanation: To find top K frequent elements in an array, convert the array to a hash map first having the element and their frequencies. Since we need highest frequencies create a minHeap and add all hashmap entries to minHeap. The key in minHeap is frequency and value is element. Once all elements are added to minHeap with size K the remaining elements will be k frequent elements.

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class E_TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,1,1,2,2,3,3,4,5,5,6,7,7,7,7,7,7};
        int[] result = topKFrequent(arr, 2);
        for(int e : result){
            System.out.print(e + " ");
        }
    } 

    private static int[] topKFrequent(int[] arr, int k) {
        int[] result = new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet())  {
            minHeap.add(new Pair(entry.getValue(), entry.getKey()));
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }

        int i=0;
        while(minHeap.size() > 0){
            result[i++] = minHeap.remove().getElement();
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        int frequency;
        int element;

        Pair(int frequency, int element) {
            this.frequency = frequency;
            this.element = element;
        }

        int getFrequency() {
            return this.frequency;
        }

        int getElement() {
            return element;
        }

        public int compareTo(Pair o) {
            return frequency - o.frequency;
        }
    }
}
