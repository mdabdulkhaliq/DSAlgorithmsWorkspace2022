/*
Assume the first element as the smallest.
Loop from next element till the last
*/
public class B_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 2};

        //Selection Sort
        //Loop from starting till 2nd last element
        for(int i=0; i<arr.length-1; i++){
            //Assume the first element as the smallest element
            int smallest = i;
            //Loop from i+1 till last element to find the smallest element
            for(int j=i+1; j<arr.length; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            //replace the smallest element at the ith position and move to next iteration of i
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        //print elements
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}