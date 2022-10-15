import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement
-----------------
    Maximum element in all subarray of size K
    arr: 1 3 -1 -3 5 3 6 7
    size (n) : 8
    window size K = 3
    Result: 3 3 5 5 6 7

Brute Force
-----------
    for ( int i = 0; i < n -  k ; i++ )
	    maxElement  = Integer.MIN_VALUE
	for ( int j = i ; j < i + k ; j++)
		maxElement =  Math.max ( maxElement, arr[j] )
	print maxElement

Identification
--------------
    Array is given
    Maximum element in subarray is asked
    Window size K is given

Explanation
-----------
Maintain a List and keep adding the elements from the array till the window size is reached. While adding the elements, if the list is empty add the element, for next elements check if the first element in the list is less than the current element then remove all the elements from the list and add the current element to the list, if the element in list is greater than the current element, then add the current element to the end of the list. 
This is because if an element is greater than the first element in the list, then all the elements in the list are smaller than the current element so we empty the list and the current element will be the maximum in that window size so we add it to the list. If not we add to the end of the list because once the maximum element which is at the beginning of the list, once its removed from the window we need the next maximum element which will be next in the list.
When the window size is reached, the max element will be at index 0 in the list, and when sliding the window if the element at i index is the same as element at 0 index in the list then remove it from the list.

Pseudo Code
-----------
int i = 0, j = 0, List<Integer> maxList
while ( j < size )
	//Calculations
 	if ( maxList.size() == 0 )
		maxList.add( arr[j] )
	else if ( maxList.get(0) < arr[j] )
		maxList.clear()
		maxList.add( arr[j] )
	else
		maxList.add( arr[j] )
	//window size is not yet reached
    if ( j - i + 1 < k )
		j++
	//window size is reached
	else if ( j - i + 1 == k )
		print maxList.get(0)
		//remove i index calculations
		if ( arr[i] == maxList.get(0) )
			maxList.removeElementAtIndex(0)
		i++ and j++ // Slide the window

Sample Iteration
----------------
    arr: 1 3 -1 -3 5 3 6 7
    maxList: 
    1 
    3 (clear all elements)
    3 -1
    3 -1 -3
    -1 -3 (3 is removed by window slide)
    5 (clear all elements)
    5 3
    6 (clear all elements)
    7 (clear all elements)

 */
public class D_MaxElementSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxElementInSizeK(nums, k);
    }

    private static void maxElementInSizeK(int[] nums, int k) {
        Queue<Integer> maxElementsList = new LinkedList<>();
        int i=0, j=0, size=nums.length;
        while(j<size){
            if(maxElementsList.isEmpty())
                maxElementsList.add(nums[j]);
            else {
                if(maxElementsList.peek() < nums[j]){
                    maxElementsList.clear();
                    maxElementsList.add(nums[j]);
                } else if(maxElementsList.peek() > nums[j]) {
                    maxElementsList.add(nums[j]);
                }
            }
            if(j-i+1 < k)
                j++;
            else {
                System.out.print(maxElementsList.peek() + " ");
                j++;
                if(nums[i] == maxElementsList.peek())
                    maxElementsList.remove();
                i++;
            }
        }
    }
}
