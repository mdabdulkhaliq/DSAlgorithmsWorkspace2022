/*
For method 1 follow same process as that of 0, 1, 2's problem.
For method 2
    Use two variable i=0 and j=n-1;
    increment i until value at ith index is < 0 and until i < j
    decrement j until value at j is > 0 and j > i
    Once we reach the next line 
        if it is still i < j it means the value at i is +ve and value at j is -ve, so swap and increment both i and j.
        or it means i = j then break.
 */
public class B_SegregatePositiveAndNegativeNums {
    public static void main(String[] args) {
        int[] arr = new int[] {-1, 3, 8, -4, 5, -6, 7, -20, 30, 40};
        //segregatePositiveAndNegativeNums1(arr);
        segregatePositiveAndNegativeNums2(arr);
    }

    public static void segregatePositiveAndNegativeNums1(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(mid <= high){
            if(arr[mid] < 0){
                int t = arr[low];
                arr[low] = arr[mid];
                arr[mid] = t;
                mid++;
                low++;
            } else {
                int t = arr[high];
                arr[high] = arr[mid];
                arr[mid] = t;
                high--;
            }
        }

        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void segregatePositiveAndNegativeNums2(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        while ( low < high) {
            while(arr[low] < 0){
                low++;
            }
            while(arr[high] > 0){
                high--;
            }
            if(low < high){
                int t = arr[low];
                arr[low] = arr[high];
                arr[high] = t;
                low++;
                high--;
            } else {
                break;
            }
        }

        //Print the final array
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}