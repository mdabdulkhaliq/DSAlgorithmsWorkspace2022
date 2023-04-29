public class ImplementQueueArray {
    static class Queue {
        static int[] elements;
        static int front = -1, rear = -1;
        static int size;
        
        //Create and initialize the Queue
        Queue(int n){
            elements = new int[n];
            size = n;
        }

        //Return false if there are no elements in Queue
        public static boolean isEmpty(){
            return rear == -1;
        }

        //When Queue is full rear will be pointing to last index
        public static boolean isFull(){
            return rear == size-1;
        }

        //enqueue
        //Check if full then return
        //Else, since rear will be pointing to last element, increment rear and add element
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            //after addition of 1st element
            if(front == -1)
                front=0;

            rear++;
            elements[rear] = data;

        }

        //dequeue
        //Check if Queue is empty return -1
        //Else, Remove always returns elements from 0 index, save that to return later
        //To optimize space, shift all elements from index 1 till rear to previous position
        //since we shifted all element to before indexes
        //rear should also shift to one place before to match last element
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int element = elements[front];
            for(int i=0; i<rear;i++){
                elements[i] = elements[i+1];
            }
            rear--;

            return element;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return elements[front];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        System.out.println("adding 1");
        q.add(1);
        System.out.println("adding 2");
        q.add(2);
        System.out.println("adding 3");
        q.add(3);
        System.out.println("adding 4");
        q.add(4);
        System.out.println("adding 5");
        q.add(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println(q.isEmpty());
    }
}
