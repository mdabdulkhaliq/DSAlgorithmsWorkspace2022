import java.util.HashSet;
import java.util.Set;

/*
    Find two odd occuring numbers in an array
Naive Approach:
    Use two loop and count the no of times the element occurs in loop.
    If it is odd print the element
    Using a set because, for every duplicate element since it is checking from beginning it counts as odd occuring element.
    Time Complexity: O(n^2) and Space Complexity: O(1)
Efficient Solution:
    Find XOR of all the elements in the array. {5,6,10,6,10,6,3,3}
        x = 5^6^10^6^10^6^3^3 = 5^6 = 00..0101 ^ 00..0110 = 00..0011 = 3
    How do we find 5 and 6 from the number 3?
        A set bit in 3 means the bit is having different values in 5 and 6
        Consider the last bit of 3 which is 1
        1 in last bit means it is an odd number so 5^3^3=5 from the array
        consider the opposite 0 in last bit means 6^10^6^10^6 = 6
        So the result is 5 and 6.
*/
public class E_TwoOddOccuringNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{7,3,3,7,7,7,7};
        Set<Integer> result = findOddOccuringNumbers(nums);
        System.out.println(result.toString());
    }   

    public static Set<Integer> findOddOccuringNumbers(int[] nums) {
        Set<Integer> result = new HashSet<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count = 0;
            for(int j=0; j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count%2 != 0){
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void findOddOccuringNumbers1(int[] nums){
        //XOR of all elements in the array
        int x = nums[0];
        for(int i=1; i<nums.length; i++){
            x = x ^ nums[i];
        }

        //This finds a number which has only 1 bit set 
        //and the set bit corresponds to the last set bit of x
        int k = x & ~(x-1);

        int result1=0, result2=0;
        for(int i=0; i<nums.length; i++){
            //Checking with bits set and bits not set to get the 2 numbers
            if((nums[i] & k) != 0){
                result1 = result1 ^ nums[i];
            } else {
                result2 = result2 ^ nums[i];
            }
        }

        System.out.println(result1 + " " + result2);

    }
}
