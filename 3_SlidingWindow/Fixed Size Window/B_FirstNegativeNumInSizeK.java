import java.util.LinkedList;
import java.util.Queue;

/*
First Negative Number in every Window of Size K, return 0 if there is no -ve number in window size k
Problem Statement/IP/OP
    arr -> 12, -1, -7, 8, -15, 30, 16, 28
    arr size n = 8
    window size k = 3
    Total no of sub arrays will be  = n-k+1 = 8-3+1 = 6
Identification
    Array is given
    window size K is given
    First negative in a subarray of size K is asked.
Explanation
    Navigate through the array from the beginning
    until window size is reached during the process, save all -ve nums in a list
    once window size is reached, the first value in the list is the first -ve number for that window
    when sliding the window, if the ith element is same as front of the list, then remove it from the list.
    If there are no elements in the list, then return 0 meaning there are no -ve nums in the window.
    nums = 12, -1, -7, 8, -15, 30, 16, 28
    negativeNumbers list = -1 -7 -15
    result = -1 -1 -7 -15 -15 0
Pseudo Code
    Queue<Integer> negativeNumbers
    while j < size
        if ( arr[j] < 0 )
            negativeNumbers.add( arr[j] )
        if ( j - i + 1 < k )
            j++
        else if ( j - i + 1 == k)
            print ( negativeNumbers.peek() )
            if ( arr[i] == negativeNumbers.peek() )
                negativeNumbers.remove()
            i++
            j++
 */
public class B_FirstNegativeNumInSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3, size = nums.length;

        System.out.println("Brute force approach");
        //Brute force approach
        bruteForceApproach(nums, size, k);

        System.out.println("Sliding Window approach");
        //Sliding Window approach
        firstNegativeNumInSizeK(nums, size, k);

    }

    public static void bruteForceApproach(int[] nums, int size, int k) {
        //loop from start to end - k
        for(int i=0; i<=size-k;i++){
            int firstNegative = 0;
            //run the inner loop from ith index to i+k index (window)
            for(int j=i; j<i+k; j++){
                if(nums[j] < 0){
                    //if we find a negative number save and break from that window
                    firstNegative = nums[j];
                    break;
                }
            }
            //print the -ve/0 number before moving on to next window.
            System.out.print(firstNegative + " ");
        }
    }

    private static void firstNegativeNumInSizeK(int[] nums, int size, int k) {
        //Initialize pointers to start of array
        int i=0, j=0;
        //Queue to store the list of all negative numbers
        Queue<Integer> negativeNums = new LinkedList<>();
        //Navigate through the array
        while(j<size){
            //Perform calculation/operation on the current element for j
            if(nums[j] < 0){
                negativeNums.add(nums[j]);
            }
            //Check if it is less than window size, simply increment j
            if(j-i+1 < k){
                j++;
            } 
            //If window size is reached
            else {
                //Check if list has any -ve number, if not print 0 as window size is reached and there are no -ve nums in the list
                if(negativeNums.size() == 0)
                    System.out.print("0 ");
                //If there are -ve nums in the list, print the front value of the queue, which will be the first -ve num for that window
                else
                    System.out.print(negativeNums.peek() + " ");
                //slide the window
                j++;
                //Before moving the starting pointer, check if the value at ith index is present in start of the queue then remove it as that element is being moved out of window.
                if(negativeNums.size() > 0 && negativeNums.peek() == nums[i])
                    negativeNums.remove();
                i++;
            }
        }
    }

}