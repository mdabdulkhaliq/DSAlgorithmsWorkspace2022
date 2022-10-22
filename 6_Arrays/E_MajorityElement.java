import java.util.HashMap;
import java.util.Map;

/*
Find the majority element in an array.
A majority element is an element that is present more than n/2 times in an array where n is length of an array.
There will be only one majority element in an array
Use a HashMap to store the count and find the majority element.
O(n) time complexity
O(n) space complexity
*/
public class E_MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,2,2,4,3,2,3,2,2};
        int majorityElement = findMajorityElement(nums);
        System.out.println(majorityElement);
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
}
