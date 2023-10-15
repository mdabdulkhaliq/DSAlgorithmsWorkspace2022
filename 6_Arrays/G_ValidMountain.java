/*
 * https://leetcode.com/problems/valid-mountain-array/description/
 * 
 */
public class G_ValidMountain {
    
    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,4,5,2,1,0};
        boolean result = validMountainArray(arr);
        System.out.println(result);
    }

    public static boolean validMountainArray(int[] arr) {
        //start from 2nd element
        int i = 1;
        
        //keep on incrementing until peak is reached
        while(i < arr.length && arr[i] > arr[i-1])
            i++;

        //Check if there is no incrementing sequence or have reached end of array i.e no decreasing seq is present
        if(i==1 || i == arr.length)
            return false;
        
        //keep incrementing until there is a decreasing sequence
        while(i < arr.length && arr[i] < arr[i-1])
            i++;
        
        //Once both increasing and decreasing seq are completed, i should reach end of array.
        return (i == arr.length);

    }
}
