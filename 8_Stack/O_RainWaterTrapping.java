//https://youtu.be/FbGG2qpNp4U?si=675SizZgx80Aiqpd
//https://leetcode.com/problems/trapping-rain-water/
//Approach: Amount of water that can be trapped between two bars/heights is equal to the min height of two bars minus height of the bars in between.
//Calcuate the maximum element to the left and maximum element to the right of the current bar. (not the nearest but will be farthest as water will be trapped in between max height bars)
//to calculate the max of left and right, assume the first value is max and then compare with each value to find max at each location for left and right.
//Between these 2 heights the max height of water that will be stored is the min of the two max heights.
//Subtract this value (min of 2 max heights) from each bar to get the unit of water stored at each location
//Sum of the units of water will give total units of water trapp

public class O_RainWaterTrapping {
    public static void main(String[] args) {
        //int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = new int[]{4,2,0,3,2,5};
        int totalUnits = trap(height);
        System.out.println(totalUnits);
    }

    private static int trap(int[] height){
        int totalUnits = 0;
        
        //Find the maximum height towards the left array for each element
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        for(int i=1; i<height.length; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        //Find the maximum height towards the right array for each element
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        //calculate the water level at each height = minOfBothHeights on left and right - current height
        int[] water = new int[height.length];
        for(int i=0; i<height.length; i++){
            water[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        //calcuate total units of water
        for(int i=0; i<height.length; i++){
            totalUnits = totalUnits + water[i];
        }
        
        return totalUnits;
    }
}
