//https://youtu.be/85LWui3FlVk?si=m8Eun5P3bcRws5uR
//Given an array of integers, find the closest (not considering distance, but value) smaller on left of every element. If an element has no smaller on the left side, print -1 . 
//Brute force - using two loops
//Performant - Use a stack to store the nearest smaller elements
//loop from left to right - if the stack is empty NSL is -1 and add the current element and proceed - if the stack is not empty and the top element in stack is smaller that is NSL and add current element and proceed - if top element is not smaller keep popping from stack as long as stack is empty in which case it is -1 or we find NSL, add current element to stack and proceed for next element iteration.

import java.util.Stack;

public class K_NearestSmallerToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 4, 10, 2, 5};
        int[] result = findNearestSmallerToLeft(arr);
        for(int element : result){
            System.out.print(element + " ");
        }
    }

    private static int[] findNearestSmallerToLeft(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                result[i] = -1;
                stack.push(arr[i]);
            } else {
                if(stack.peek() < arr[i]){
                    result[i] = stack.peek();
                    stack.push(arr[i]);
                } else {
                    while(!stack.isEmpty() && stack.peek() >= arr[i]){
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
