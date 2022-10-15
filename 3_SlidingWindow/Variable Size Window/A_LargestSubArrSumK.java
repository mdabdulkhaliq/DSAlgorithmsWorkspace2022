/*
Problem Statement
-----------------
    Largest subarray of sum K with only +ve numbers
    arr: 4 1 1 1 2 3 5
    size: 7
    condition: sum K = 5
    Result: 4
    Other candidates are: 4 and 1, 2 and 3, 5 alone

Fixed size window:
------------------
    Window size is fixed
    Maximize or Minimize sum
    Code checks window size j - i +1
    Will get an answer candidate when window size = K
    Initially, we keep on increasing window size until we reach K

Variable size window:
---------------------
    Condition/Sum is fixed.
    Maximize or minimize window size.
    Code checks for condition instead of window size.
    Will get an answer candidate when condition = K
    Initially, we increase window size until we reach condition = K
    If we cross the condition, reduce window size from ith position as long as we are crossing the condition

Explanation
-----------
Start with i, j from index 0, and maintain an internal condition/sum check. Keep adding elements from index j until the condition is reached or crossed. If the condition is reached check for result and add the next element (this will cross the result). When the result is crossed naturally or after increasing j then keep on removing i calculations and increasing i until it comes back to less than or equal to K.
In a fixed size window once the window size is reached we maintain it so it will have < and = conditions only. Whereas in a variable size window it can have < , = and > conditions because window size is not fixed and calculations can go over K.

Pseudo Code
-----------
    //Initializations
    i = 0, j = 0, sum = 0, maxLen = 0
    while ( j < size)
        //do the calculations
        sum = sum + arr[j]
        if ( sum < k ) //if we have not yet reached the condition
            j++ //increment to reach condition
        else if ( sum == k ) //Condition is reached
            maxLen = Math.max( maxLen, j - i + 1 ) //Get result when condition is met
            j++ //increment window
        else if ( sum > k ) //Crossed the condition
            while ( sum > k ) //As long as it is greater than condition
                sum = sum - arr[i] //Remove calculations of i and decrease window size to go back to condition
                i++
            j++

Variable size window pattern
-----------------------------
while j < size
	do the calculations
	if condition < k
		j++
	else if condition == k
		Get answer from the calculations
		j++
	else if condition > k
		while condition > k
			Remove calculations of i
			i++
		j++
return answer
 */
public class A_LargestSubArrSumK {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 1, 1, 2, 3, 5};
        int k = 5; //maxSum

        int maxSizeSubArr = largestSubArrSumK(nums, k);
        System.out.println(maxSizeSubArr);

    }

    private static int largestSubArrSumK(int[] nums, int k) {
        int i=0, j=0, size = nums.length;
        int sum = 0, maxSize = 0;
        while(j<size){
            sum = sum + nums[j];
            if(sum < k)
                j++;
            else if(sum == k){
                maxSize = Math.max(maxSize, j-i+1);
                j++;
            } else if(sum > k){
                while(sum > k){
                    sum = sum - nums[i];
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }
}
