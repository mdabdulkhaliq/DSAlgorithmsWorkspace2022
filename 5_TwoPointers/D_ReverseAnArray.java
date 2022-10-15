/*
 * Reverse an array without using extra space.
 * Use two pointers low and high
 * low pointing at 0 and high pointing at n-1
 * swap elements at low and high
 * increment low and decrement high
 * until low < high
 */
public class D_ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        reverseArray(arr);
    }
    public static void reverseArray(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
            low++;
            high--;
        }
        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
