/*Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

This problem follows the Sliding Window pattern and is quite similar to Longest Substring with same Letters after Replacement. The only difference is that, in the problem, we only have two characters (1s and 0s) in the input arrays.

Following a similar approach, we’ll iterate through the array to add one number at a time in the window. We’ll also keep track of the maximum number of repeating 1s in the current window (let’s call it maxOnesCount). So at any time, we know that we can have a window which has 1s repeating maxOnesCount time, so we should try to replace the remaining 0s. If we have more than ‘k’ remaining 0s, we should shrink the window as we are not allowed to replace more than ‘k’ 0s.
*/

public class I_LongestSubArrayHavingAllOnes {
    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int result = longestSubArray(nums, k);
        System.out.println(result);
    }

    private static int longestSubArray(int[] nums, int k){
        int windowStart = 0, windowEnd = 0, maxOnesCount = 0, maxArrayLength = 0, remainingNumsLength = 0;

        //check if the current number is 1 then count max ones.
        while (windowEnd < nums.length){
            if(nums[windowEnd] == 1){
                maxOnesCount++;
            }

            //count remaining numbers length in the window
            //using if instead of while because we are only incrementing one number at a time and this is not like sum etc where we need a while loop to keep on increasing or decreasing.
            remainingNumsLength = windowEnd - windowStart + 1 - maxOnesCount;
            if(remainingNumsLength > k){
                if(nums[windowStart] == 1){
                    maxOnesCount--;
                }
                windowStart++;
            }

            //Get result
            maxArrayLength = Math.max(maxArrayLength , windowEnd - windowStart + 1);
            windowEnd++;
        }

        return maxArrayLength;

    }
}