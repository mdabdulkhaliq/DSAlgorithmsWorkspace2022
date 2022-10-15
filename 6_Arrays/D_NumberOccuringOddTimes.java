/*
Find the number that occurs odd number of times in an array.
There will be only 1 such number.
Method 1
    Two for loops and check the count, O(n square) time complexity.
Method 2
    Use a Hashmap and store the counts, O(n) time complexity and O(n) extra space
Method 3
    Use XOR, do a XOR on all the elements in the array
    Since a XOR a is 0
    b XOR 0 is b
    So whichever element is odd number of times will remain and all other even elements will cancel out.
*/
public class D_NumberOccuringOddTimes {
    public static void main(String[] args) {
        //2 is present odd times.
        int[] nums = new int[] {1,5,5,1,2,3,4,2,1,2,1,2,3,2,4};
        findOddOccuringNumber(nums);
    }

    public static void findOddOccuringNumber(int[] nums){
        int oddOccuringNumber = nums[0];
        for(int i=1;i<nums.length;i++){
            oddOccuringNumber = oddOccuringNumber ^ nums[i];
        }
        System.out.println("oddOccuringNumber is " + oddOccuringNumber);
    }
}
