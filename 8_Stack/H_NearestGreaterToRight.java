//https://youtu.be/NXOOYYwpbg4?si=2dqkMRo9igYIsyJ7
//Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
//Brute force approach - Use two loops
//Performant approach - Use a stack.
//start loop from right to left, for every element if stack is empty then NGR is -1, if element on top of stack is greater than that is the NGR and then add the current element, if the element on top of stack is not NGR keep popping until either we see a NGR or the stack is empty in which case -1 and then add the current element to the stack and proceed to next element in the iteration.

import java.util.Stack;

public class H_NearestGreaterToRight {
    public static void main(String[] args) {
        int[] arr = new int[] { 6,8,0,1,3 };
        int[] result = findNextGreaterElement(arr);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }

    private static int[] findNextGreaterElement(int[] arr) {
        //create a result array to hold the next greater element for each element in original array
        int[] result = new int[arr.length];
        //Stack to hold the nearest greater elements
        Stack<Integer> stack = new Stack<>();

        //Loop from behind the array
        for (int i = arr.length - 1; i >= 0; i--) {
            //If stack is empty, then the NGR is -1
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                //If stack is not empty and the top most element is greater than the array element then that is the NGR element
                if (stack.peek() > arr[i]) {
                    result[i] = stack.peek();
                } else {
                    //If stack is not empty and top most is not greater, then keep deleting elements until you find a greater or stack is blank
                    while (stack.size() > 0 && stack.peek() <= arr[i]) {
                        stack.pop();
                    }
                    //If stack is empty then NGR is -1
                    if (stack.isEmpty()) {
                        result[i] = -1;
                    } else {
                        //If we have removed smaller elements and stack is not empty, then the current stack element is the NGR
                        result[i] = stack.peek();
                    }
                }
            }
            //Add the current element to the top of the stack before moving to next iteration
            //Added here to avoid adding this statement to every if and else block above
            stack.push(arr[i]);
        }
        return result;
    }
}