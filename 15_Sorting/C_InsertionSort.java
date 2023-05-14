/*
    Split the array into two parts - Sorted and unsorted
    Begin with assuming arr[0] is sorted and rest as unsorted
    Loop through all the unsorted elements
    Keep track on current element to be inserted into sorted array
    Keep track of Ending position of sorted array

*/
public class C_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 8, 3, 1, 2};

        for(int i=1; i<arr.length;i++){
            int currentElement = arr[i];    
            int j = i-1;

            while(j >= 0 && currentElement < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }

            //insert at correct position
            arr[j+1] = currentElement;
        }

        //print elements
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
