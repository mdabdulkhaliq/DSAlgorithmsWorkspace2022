/*
 * If we want to rotate an array by r places.
 * Split array in two parts A and B. A = 0 to n-r and B is n-r+1 to n.
 * Reverse Array A and Reverse Array B
 * Reverse the whole array again Reverse(Reverse(A)Reverse(B))
 */
public class B_RotateAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int r = 3;
        rotateArray(arr, r);
    }
    public static void rotateArray(int[] arr, int r){
        System.out.println("Reversing A");
        reverseArray(arr, 0,arr.length-1-r);
        System.out.println("Reversing B");
        reverseArray(arr, arr.length-1-r+1, arr.length-1);
        System.out.println("Reversing AB");
        reverseArray(arr, 0,arr.length-1);
        System.out.println("Printing");
        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void reverseArray(int[] arr, int start, int end){
        int low = start;
        int high = end;
        while(low<high){
            int t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
            low++;
            high--;
        }
    }
}
