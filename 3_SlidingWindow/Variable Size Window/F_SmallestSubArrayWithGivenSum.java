/*
Problem Statement
-----------------
    Smallest contiguous subarray whose sum is greater than or equal to ‘S’

Variable size window:
---------------------
    Condition is fixed = Sum is greater than or equal to S.
    Minimize window size.
    Will get an answer candidate when condition = K
    Initially, we increase window size until we reach condition = K
    If we cross the condition, reduce window size from starting position as long as we are crossing the condition

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

Explanation
-----------
Initialise all required variables -> windowStart, windowEnd, currentSum, minArrayLength
Loop until windowEnd < arraylength
if the currentSum is < the givensum add the element
After adding element, if currentSum >= givensum calculate the result and as long as currentSum >= givenSum keep reducing the windowStart and calculate result for smaller windows
Print the result
 */

public class SmallestSubArrayWithGivenSum {
    public static void main(String args[]){
        int[] nums = new int[] {2,1,5,2,3,2};
        int givenSum = 7;
        int result = getSmallestArray(nums, givenSum);
        System.out.println("RESULT*** "+result);
        
        nums = new int[] {2,1,5,2,8};
        givenSum = 7;
        result = getSmallestArray(nums, givenSum);
        System.out.println("RESULT*** "+result);
        
        nums = new int[] {3,4,1,1,6};
        givenSum = 8;
        result = getSmallestArray(nums, givenSum);
        System.out.println("RESULT*** "+result);
    }
    
    private static int getSmallestArray(int[] nums, int givenSum){
        int windowStart = 0;
        int windowEnd = 0;
        int smallestLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int arrayLength = nums.length;
        
        while(windowEnd < arrayLength){
            if(currentSum < givenSum){
                currentSum = currentSum + nums[windowEnd];
            }
            
            while(currentSum >= givenSum){
                smallestLength = Math.min(smallestLength, windowEnd-windowStart+1);
                currentSum = currentSum - nums[windowStart];
                windowStart++;
            }
            
            windowEnd++;
        }
            
            return smallestLength;
    }
}