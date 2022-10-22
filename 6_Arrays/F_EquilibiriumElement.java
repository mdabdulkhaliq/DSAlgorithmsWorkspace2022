/*
Find the equilibirium element in the array
An element is the equilibirium element if the sum of elements on LHS = sum of elements on RHS.
Logic:
    Calculate the total sum of the array
    Start with LeftSum = 0 and RighSum = 0
    RightSum = totalSum
    Loop through all elements
        subtract the current element from rightSum
        Check if the LS = RS
            If its same then that element is the equilibirum element
        If not add that element to the leftSum
*/
public class F_EquilibiriumElement {
    public static void main(String[] args) {
        int[] nums = new int[]{-7,1,5,2,-4,3,0};
        int index = findEquilibiriumElement(nums);
        System.out.println("Equilibirium element index is " + index);
    }

    public static int findEquilibiriumElement(int[] nums){
        int totalSum = 0, rightSum = 0, leftSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        rightSum = totalSum;
        for(int i=0;i<nums.length;i++){
            rightSum = rightSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
