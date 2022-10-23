import java.util.HashMap;
import java.util.Map;

/*
Find the majority element in an array.
A majority element is an element that is present more than n/2 times in an array where n is length of an array.
There will be only one majority element in an array
Method 1:
---------
    Use a HashMap to store the count and find the majority element.
    O(n) time complexity
    O(n) space complexity

Method 2: Moores Voting Algorithm
----------------------------------
https://www.youtube.com/watch?v=n5QY3x_GNDg&t=327s&ab_channel=TECHDOSE
    There are 2 steps in Moores voting algorithm
    1. Find a candidate for the majority element
    2. Verify if the candidate is the majority element.
    Moores voting algorithm always returns majority element as a candidate and we need to confirm if that element is majority or not.
    Logic:
        Maintain a majorityElement and Counter variables
        Loop through all elements of the array
            First element is majorityElement and count = 1
            If the next element is not same as majorityElement, decrement count
            if count !=0 move on to next element and majorityElement will remain same.
            If count = 0, change the majorityElement to current element and reset count = 1
            If majorityElement is same as nextElement increment count.
        Once we get the majorityElement as the candidate
        Loop through all elements and check if frequency of the element is > n/2
    Time Complexity: O(n)
    Space Complexity: O(1)
*/
public class E_MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,2,2,4,3,2,3,2,2};
        int majorityElement = findMajorityElement(nums);
        System.out.println(majorityElement);
        //Moores Voting Algorithm
        int candidate = findCandidate(nums);
        boolean result = validateCandidate(nums, candidate);
        if(result)
            System.out.println("Majority element is " + candidate);
        else
            System.out.println("There is no majority element");
    }

    public static int findMajorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            } else {
                int count = map.get(nums[i])+1;
                map.put(nums[i], count);
                if(count>n)
                    return nums[i];
            }
        }
        return -1;
    }

    public static int findCandidate(int[] nums){
        int majorityElement = nums[0], count = 1;
        for(int i=1;i<nums.length;i++){
            if(majorityElement == nums[i]){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                majorityElement = nums[i];
                count = 1;
            }
        }
        return majorityElement;
    }

    public static boolean validateCandidate(int[] nums, int candidate){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(candidate == nums[i])
                count++;
            if(count > nums.length/2)
                return true;
        }
        return false;
    }

}
