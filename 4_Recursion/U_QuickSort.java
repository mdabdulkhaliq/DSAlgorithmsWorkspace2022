/*
    Quick sort Implementation
    Find a pivot element - First element or last element or middle element or median.
    For this implementation we take the last element as the pivot element.
    Loop through array and move all elements less than pivot to left and greater than pivot to right
    Recursively perform the same steps now for the array to the left of pivot and right of pivot
    Worst case: O(n^2) happens when pivot is always the smallest or largest element i.e array is sorted already
        every loop we will iterate n, n-1, n-2, .... 1 element which is n*(n+1)/2 which is O(n^2)
    Avergae case: O(n logn)
    So worst case occurs rarely and avg case is nlogn and is better than merge sort as this does not use any extra space
*/
public class U_QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        //array to be sorted, starting index and last index
        quickSort(arr, 0, n-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = createPartition(arr, low, high);
            quickSort(arr, 0, pivotIndex-1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int createPartition(int[] arr, int low, int high){
        //consider the last element in the array as pivot but we need to find the correct position of the pivot element in the array
        int pivot = arr[high];

        //To track the position which can be filled in, if we find a element lower than pivot
        int i = low-1;

        //since we already took element at high index as pivot loop till the before element
        for(int j=low; j<high; j++){
            //track location of smaller elements with i and keep filling it with smaller element
            if(arr[j] < pivot){
                i++;
                //swap jth element from array to ith index as it is lesser than pivot
                //this will move larger elements towards end of array
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //now to move the pivot to correct position by doing one last swap to fill the ith position this will make all greater elements to right of pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        
        //return pivot index;
        return i;
    }
}
