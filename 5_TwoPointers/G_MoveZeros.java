/*
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class G_MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        //pointer where non zero elements should be placed
        int index = 0;

        //loop through all elements to check for non-zero elements and move to index location
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
                nums[index] = nums[i];
                index++;
            }
        }

        //after looping through all elements index will be at next position after non-zero elements
        //fill in all elements from index till end of array with 0
        for(int i= index; i<nums.length; i++){
            nums[i] = 0;
        }

        //print result
        for(int i=0; i<nums.length; i++){
            System.err.print(nums[i] + " ");
        }

    }

}
