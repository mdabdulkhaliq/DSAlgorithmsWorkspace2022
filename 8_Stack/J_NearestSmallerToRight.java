import java.util.Stack;

//https://youtu.be/nc1AYFyvOR4?si=Bt2Uim3B_FR7CGr7
//Given an array of integers, find the closest (not considering distance, but value) smaller on rightof every element. If an element has no smaller on the right side, print -1. . 
//Solution: Brute force - use two loops
//Performant solution - Use a stack
//loop from right to left - check if stack is empty then NSR is -1 and add current element to stack - if stack is not empty check if stack top is less than element then that is NSR and add current element - if not keep popping from stack as long as we get a NSR or stack is empty - In which case we get the NSR or will be -1 and add the current element and then proceed to next element iteration.

public class J_NearestSmallerToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 5, 2, 25};
        int[] result = findNearestSmallerToRight(arr);
        for(int element : result){
            System.out.print(element + " ");
        }
    }

    private static int[] findNearestSmallerToRight(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
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
