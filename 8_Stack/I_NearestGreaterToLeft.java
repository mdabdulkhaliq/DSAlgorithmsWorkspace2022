/*
https://youtu.be/T5s96ynzArg?si=VQBatuLwscVw-w8W
Given an array of integers, find the closest (not considering distance, but value) greater on left of every element. If an element has no greater on the left side, print -1 . 
Solution: 
Brute force approach - use two loops - 0th element is -1 and then first loop going from loop 1 to n-1 and second loop going from i-1 to i>=0
Performant approach - if the second loop is dependent on first loop there is a possibility that we can use a stack
Create a stack, Loop from 0 to n-1, for every element - if stack is empty - add -1 to result and add the current element to stack, if stack is not empty and the top element is greater than that is NGL and then add the current element to the stack, if the top element is not greater keep popping until stack is empty  in which case NGL is -1 or if a NGL element is found. Then add the current element to top of the stack and proceed with next element in the iteration
*/

import java.util.Stack;

public class I_NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 11, 6, 20, 12};
        int[] result = findNeartestGreaterToLeft(arr);
        for(int element : result){
            System.out.print(element + " ");
        }
    }

    private static int[] findNeartestGreaterToLeft(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(arr[i]);
            } else {
                if(stack.peek() > arr[i]){
                    result[i] = stack.peek();
                    stack.push(arr[i]);
                } else {
                    while(!stack.isEmpty() && stack.peek() < arr[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[i] = -1;
                        stack.push(arr[i]);
                    } else {
                        result[i] = stack.peek();
                        stack.push(arr[i]);
                    }
                }
            }
        }

        return result;
    }
}
