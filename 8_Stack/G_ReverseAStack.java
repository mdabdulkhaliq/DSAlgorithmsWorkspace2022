import java.util.Stack;

/*
 * Method 1: Use another stack and push all elements from stack 1 to stack 2
 * Stack 2 will have all elements in reverse
 * Method 2: Recursion
 * Keep popping elements until stack is empty
 * Once stack is empty, start inserting elements to bottom of stack instead of push (which will insert at top of stack)
 * 
 */
public class G_ReverseAStack {    

    public static void pushAtBottom(int data, Stack<Integer> s){
        
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(top, stack);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        reverseStack(s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
