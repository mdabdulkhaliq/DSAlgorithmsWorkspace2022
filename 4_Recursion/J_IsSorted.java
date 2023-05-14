/*
    Check if all the elements in an array is strictly sorted (increasing order)
    Base Case
        if idx is arr.length-1 (last element) return true;
    Else 
        Check if current element is less than next element
            Yes - Recursive call with idx+1
            Else - Return false
*/
public class J_IsSorted {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        boolean result = isSorted(arr, 0);
        System.out.println(result);
    }

    public static boolean isSorted(int[] arr, int idx){
        if(idx == arr.length-1){
            return true;
        }

        if(arr[idx] < arr[idx+1]){
            return isSorted(arr, idx+1);
        } else {
            return false;
        }
    }
}
