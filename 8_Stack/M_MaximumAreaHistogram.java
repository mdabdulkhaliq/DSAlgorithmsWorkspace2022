//https://youtu.be/J2X70jj_I1o?si=UufW-9oNE5g-hdRF
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
//Brute Force - Iterate through all elements - For every element run another loop to check the left heights having greater than or equal to continuous bars and another loop on right to check greater than or equal to heights. Distance (difference in indexs) Left and Right bars will contribute to the width and height will be that elements height - O(n^2)
//Performant solution - Check for nearest smallest element on left and right - which will give us width * height of each element.

import java.util.Stack;

public class M_MaximumAreaHistogram {
    public static void main(String[] args) {
        int[] heights = new int[]{6,2,5,4,5,1,6};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        
        //find the index of nearest smallest element to left
        int[] leftIndexes = nearestSmallerToLeft(heights);

        //find the index of nearest smallest element to right
        int[] rightIndexes = nearestSmallerToRight(heights);
        
        //calculate the width of rectangle =  rightIndex - leftIndex - 1;
        int[] widths = new int[heights.length];
        for(int i=0; i<leftIndexes.length; i++){
            widths[i] = rightIndexes[i] - leftIndexes[i] - 1;
        }
        
        //calcuate the area of rectangle = width * height
        for(int i=0; i<widths.length; i++){
            int area = widths[i] * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        
        //return max area rectangle
        return maxArea;
    }
    
    //class to store element and its corresponding index value in a stack
    private static class Pair{
        int element;
        int index;

        public Pair(int element, int index){
            this.element = element;
            this.index = index;
        }

        public int getElement(){
            return this.element;
        }

        public int getIndex(){
            return this.index;
        }
    }

    //find indexes of nearest smaller element to left for each height
    private static int[] nearestSmallerToLeft(int[] heights){
        int[] result = new int[heights.length];
        Stack<Pair> stack = new Stack<>();
        
        for(int i=0; i<heights.length; i++){
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(new Pair(heights[i],i));
            } else {
                if(stack.peek().getElement() >= heights[i]){
                    while(!stack.isEmpty() && stack.peek().getElement() >= heights[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[i] = -1;
                        stack.push(new Pair(heights[i],i));
                    } else {
                        result[i] = stack.peek().getIndex();
                        stack.push(new Pair(heights[i],i));
                    }

                } else {
                    result[i] = stack.peek().getIndex();
                    stack.push(new Pair(heights[i],i));
                }
            }
        }

        return result;
    }

    //find indexes of nearest smaller element to right for each height
    private static int[] nearestSmallerToRight(int[] heights){
        int[] result = new int[heights.length];
        Stack<Pair> stack = new Stack<>();

        for(int i=heights.length-1; i>=0; i--){
            if(stack.isEmpty()){
                result[i] = heights.length;
                stack.push(new Pair(heights[i],i));
            } else {
                if(stack.peek().getElement() >= heights[i]){
                    while(!stack.isEmpty() && stack.peek().getElement() >= heights[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[i] = heights.length;
                        stack.push(new Pair(heights[i],i));
                    } else {
                        result[i] = stack.peek().getIndex();
                        stack.push(new Pair(heights[i],i));
                    }
                } else {
                    result[i] = stack.peek().getIndex();
                    stack.push(new Pair(heights[i],i));
                }
            }
        }

        return result;
    }


}
