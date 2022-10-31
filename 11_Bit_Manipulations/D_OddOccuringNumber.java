/*
    Find the only odd occuring number
Naive Solution:
    Use two loops count occurence of each number
    Check if it is odd or even.
    Time Complexity: O(n^2)
Better Solution:
    Use a hash map
    Time Complexity: O(n), Space Complexity: O(n)
Efficient Solution:
    XOR all numbers in the array.
    only the odd one will remain
    x ^ 0 = x
    x ^ x = 0
    x ^ y = y ^ x
    x ^ (y ^ z) = (x ^ y) ^ z
*/
public class D_OddOccuringNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{7,3,3,7,7,7,7};
        int result = findOddOccuringNumber(nums);
        System.out.println(result);
        int result1 = findOddOccuringNumber1(nums);
        System.out.println(result1);
    }

    public static int findOddOccuringNumber(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count = 0;
            for(int j=0; j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count%2 != 0){
                return nums[i];
            }
        }
        return -1;
    }

    public static int findOddOccuringNumber1(int[] nums) {
        int result = nums[0];
        for(int i=1; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
