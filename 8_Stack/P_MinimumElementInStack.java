//https://youtu.be/asf9P2Rcopo?si=Na5S-Xe3S9KzM45x
//https://leetcode.com/problems/min-stack/
//Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
//Approach: Using additional space O(n)
//maintain an additional stack to track the minimum element.
//At the beginning when additional stack is empty, insert the element into both main stack and additional stack, later when pushing push onto main stack but push into additional stack only when the element being inserted is less than top of additional stack.
//when popping an element check if the element being popped is same as top of additional stack then remove element from additional stack as well.

import java.util.Stack;

public class P_MinimumElementInStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }    
}

class MinStack {
    Stack<Integer> s;
    Stack<Integer> ss;
    
    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }
    
    public void push(int val) {
        if(ss.isEmpty() || ss.peek() >= val){
            ss.push(val);
        }
        s.push(val);
    }
    
    public void pop() {
        if(!s.isEmpty()) {
            int ele = s.pop();
            if(!ss.isEmpty() && ss.peek() == ele){
                ss.pop();
            }
        }
    }
    
    public int top() {
        if(s.isEmpty())
            return -1;
        else
            return s.peek();
    }
    
    public int getMin() {
        if(!ss.isEmpty()){
            return ss.peek();
        } else{
            return -1;
        }
    }
}