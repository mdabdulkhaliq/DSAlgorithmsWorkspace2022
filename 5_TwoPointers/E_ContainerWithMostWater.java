/*
 * https://leetcode.com/problems/container-with-most-water/description/
 * Brute force - 2 loops calculate all areas
 * O(n) - two pointers pointing to left and right of array (max width), calculate the area, now for next iteration we have to move pointers i.e it will reduce the width so we need to maximize the length. Move the pointer with lesser height to next element and calculate the area, until left and right pointer dont meet.
 */
public class E_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = getContainerWithMostWater(height);
        System.out.println(maxArea);
    }

    private static int getContainerWithMostWater(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            int currentArea = width * length;
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

}