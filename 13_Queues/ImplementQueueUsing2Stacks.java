import java.util.Stack;

//Logic: To add an element pop all elements from stack1 and insert into stack 2
//insert the element into stack1
//pop all elements from stack2 and insert back into stack1
public class ImplementQueueUsing2Stacks {

    static class Queue {
        //Create the 2 stacks and initialize
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //if the main stack s1 is empty return true
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            //until stack1 is not empty, push all to stack2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            //insert element in stack1
            s1.push(data);

            //push back all elements from stack2 into stack1 again
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        q.isEmpty();
    }
}
