/*
 * Implement a stack using Linked list
 */
public class C_StackUsingLinkedList {

    //class representing a single node
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    //class representing a stack
    static class Stack {
        public static Node head;

        //method to check if stack is empty
        public static boolean isEmpty(){
            return head == null;
        }

        //method to insert data into a stack
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            //repoint the new node to current head
            //make head the new node
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            //Check if stack is empty
            if(isEmpty()){
                return -1;
            }
            //Retieve the current head value to delete and return
            int top = head.data;
            //point the head to next element
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            return top;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
