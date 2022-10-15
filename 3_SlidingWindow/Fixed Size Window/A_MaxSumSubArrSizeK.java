/*
Maximum sum sub-array of size K.
--------------------------------
Problem Statement/Input/Output
    arr -> 2 5 1 8 2 9 1
    size -> 7
    window size k -> 3
    max sum sub-array of size k
Identification
    Given Array
    Asked sub array
    Need "Max" sum
    Given window size k
Explanation
    We will maintain two pointers to represent start (i) and end (j) of window, i and j both starting at index 0 for window size. We increment the window size by incrementing j. Window size can be calculated as j-i+1
    Initially since both i and j are at 0, to create the window size keep incrementing j until j-i+1 < k, once j-i+1 == k we have window size.
    During the window creation, calculate the sum of the window.
    Once window size == k, then do the calculation to find max sub array.
Pseudo Code
    i = 0, j = 0, sum = 0, maxSum = 0
    while ( j < size)
        sum = sum + arr[j] // Do the calculations
        if ( j-i+1 < k) // If the window size is not reached
            j++ // increment the end pointer to reach the window size
        else if ( j-i+1 == k) // if window size is reached
            maxSum = Math.max( sum, maxSum) // Get the result from the calculations
            sum = sum - arr[i] // Remove the i index calculation
            i++ , j++ // Slide the window, calculation for j will be done at the start, if j is in scope.
    return maxSum
 */
public class A_MaxSumSubArrSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        //Brute force approach
        int maxSum = bruteForceApproach(nums, k);
        System.out.println("BruteForce: Max sum sub-array of size 4 is " + maxSum);

        //Sliding window approach
        maxSum = maxSumSubArraySizeK(nums, k);
        System.out.println("SlidingWindow: Max sum sub-array of size 4 is " + maxSum);
    }

    public static int bruteForceApproach(int[] nums, int k){
        int maxSum = Integer.MIN_VALUE, size = nums.length;
        for(int i=0; i<=size-k; i++){
            int sum = 0;
            for(int j=i; j<i+k; j++){
                sum = sum + nums[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static int maxSumSubArraySizeK(int[] nums, int k){
        //Initialize pointers to start of array
        int i=0, j=0, sum=0, maxSum=Integer.MIN_VALUE;
        int size = nums.length;
        //need to navigate through the entire nums array
        while(j<size){
            //calculate sum during creation of window of size k
            sum = sum + nums[j];
            //if window size is not reached, just increment j to reach to window size
            if(j-i+1 < k){
                j++;
            } else { //window size reached, calculate maxSum
                maxSum = Math.max(sum, maxSum);
                //slide the window, by removing element from starting and incrementing i
                sum = sum - nums[i];
                i++;
                //increment j, and the value at the j will be added in next iteration if it is in scope
                j++;
            }
        }
        return maxSum;
    }
}
