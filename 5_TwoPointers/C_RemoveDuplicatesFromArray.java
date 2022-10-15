/*
    Remove duplicates from an array
    Method 1: O(n) extra space
        Navigate from 0 to n-2
        if i == i+1 just increment
        if i != i+1 add element at i to a temp array.
        Add the last remaining element to the temp array.
    Method 2: No extra space.
        start with i and j pointing at arr[0] till n-2
        if element at i and i+1 are same increment i.
        if element at i and i+1 are not same increment i and j.
        Add the last remaining element to the jth location.
*/
public class C_RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,3,3,4,4,4,5};
        removeDuplicates(arr);
        removeDuplicates2(arr);
    }

    public static void removeDuplicates(int[] arr){
        int[] temp = new int[arr.length];
        int j = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] != arr[i+1]){
                temp[j] = arr[i];
                j++;
            }
        }
        temp[j] = arr[arr.length-1];

        //Print the final array
        for(int i=0; i<temp.length;i++){
            System.out.print(temp[i] + " ");
        }

    }

    public static void removeDuplicates2(int[] arr){
        int j=0;
        for(int i=0; i<arr.length-1;i++){
            if(arr[i] != arr[i+1]){
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[arr.length-1];

        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
