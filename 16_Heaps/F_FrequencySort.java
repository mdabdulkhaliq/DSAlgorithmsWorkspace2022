//https://youtu.be/hLR5aMzYGGk?si=ry52IWz5nOqJpqG7
//https://leetcode.com/problems/sort-array-by-increasing-frequency/
//Explanation: Add all elements to the heap with element and frequency. Add the heap values (frequencies) to a maxHeap containing a Pair(frequency and element). Once all elements are added to heap, pop one by one and add to element to the resultant array frequency number of times. 

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class F_FrequencySort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3};
        int[] result = frequencySort(arr);
        for(int ele: result){
            System.out.print(ele + " ");
        }
    }

    private static int[] frequencySort(int[] arr){
        int[] result = new int[arr.length];

        //Add all elements to the map with frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }

        //Add elements from map to maxHeap as a Pair with frequency as key and element as value
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
        }

        //Remove all elements from maxHeap and repeat the element frequency number of times.
        int i=0;
        while(maxHeap.size() > 0){
            Pair p = maxHeap.remove();
            for(int j=0; j<p.getFrequency(); j++){
                result[i++] = p.getElement();
            }
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
