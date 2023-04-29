public class ImplementQueueLinkedList {
    
    //Inner class to represent a LL Node.
    static class Node {
        Node next;
        int data;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue {
        //pointers to track head and tail of linked list for queue operations
        Node head = null;
        Node tail = null;

        //Return false if both head and tail are pointing to null
        public boolean isEmpty(){
            return head == null && tail == null;
        }

        //enqueue
        public void add(int data){
            
            //Create a new node
            Node newNode = new Node(data);
            
            //for the first element, point both head and tail to new node.
            if(tail == null){
                head = tail = newNode;
                return;
            }
            
            //for existing list point tail.next to new node, make new node as tail
            tail.next = newNode;
            tail = newNode;

        }

        //dequeue
        public int remove(){
            System.out.println("Request to remove ");
            //if queue is empty return -1
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            //store current head value to return
            //point head to next element
            //return the stored value that is deleted
            int element = head.data;

            //if there is only 1 element present
            if(head == tail){
                tail = null;
                head = null;
                return element;
            }

            //if there are more than 1 element
            head = head.next;
            return element;
        }

        //return the current value of head
        public int peek(){
            System.out.println("Request to peek");
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            System.out.println("Peek element is " + head.data);
            return head.data;
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
            q.peek();
            q.remove();
        }

        q.isEmpty();
    }
}
