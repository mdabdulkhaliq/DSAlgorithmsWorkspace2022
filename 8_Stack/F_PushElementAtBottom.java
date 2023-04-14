import java.util.Stack;

/*
 * Push element at the bottom of the stack
 * Keep removing elements until stack is empty
 * add the element when stack is empty
 * add back the popped element back to stack
 */
public class F_PushElementAtBottom {    

    public static void pushAtBottom(int data, Stack<Integer> s){
        
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        
        pushAtBottom(4, s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
