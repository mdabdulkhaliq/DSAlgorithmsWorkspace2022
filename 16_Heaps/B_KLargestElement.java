import java.util.PriorityQueue;

public class B_KLargestElement {
    public static void main(String[] args) {
        int[] arr = new int[] {12, 5, 787, 1, 23};
        int k = 3;
        int[] result = findKLargestElements(arr, k);
        for(int element : result){
            System.out.println(element);
        }

        
    }

    private static int[] findKLargestElements(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
               minHeap.remove();
            }
        }

        int[] result = new int[minHeap.size()];
        int i=0;
        while(minHeap.size() > 0){
            result[i++] = minHeap.remove();
        }

        return result;

    }
}
