/*

*/
public class V_MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n-1);
    }

    public static void divide(int[] arr, int startIndex, int endIndex){

        if(startIndex >= endIndex){
            return;
        }
        
        //to avoid integer overflow, same as end - start /2
        int midIndex = startIndex + (endIndex-startIndex)/2;

        divide(arr, startIndex, midIndex);
        divide(arr, midIndex+1, endIndex);

       //conquer(arr, startIndex, midIndex, endIndex);

    }

    public static void conquer(int[] arr, int s) {
        
    }
}
