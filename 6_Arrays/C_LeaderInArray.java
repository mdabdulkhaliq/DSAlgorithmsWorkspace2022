/*
A leader in an Array: For a leader L all elements on the right side of the L are < L.
Brute Force:
    Use two loops i = 0 to n-2 and j = i+1 to n-1
    if ith element is greater than all elements in j loop then ith element is a leader
O(n) approach:
    Right most element is always a leader as there are no other elements to the right of it.
    Store the n-1 (last element as max element)
    Start from n-2 till 0
    If the element is greater than the max element it means the element is greater than all other elements on the right side, print it and save this as max now.
    This will print all leaders in the array.
 */
public class C_LeaderInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{15,16,3,2,6,1,4};
        leadersInAnArray(arr);
    }
    
    public static void leadersInAnArray(int[] arr){
        int n = arr.length;
        int max = arr[n-1];
        System.out.print(max + " ");
        for(int i=n-2; i>=0; i--){
            if(arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");
            }
        }
    }
}
