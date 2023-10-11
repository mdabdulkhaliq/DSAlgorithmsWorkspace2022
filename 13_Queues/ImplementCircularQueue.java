public class ImplementCircularQueue {
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
            return rear == -1 && front == -1;
        }

        //When Queue is full rear will be just 1 index behind
        //check with %size for circular queue to see if both are same then its full
        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //enqueue
        public static void add(int data){
            System.out.println("Request to add " + data);
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            //for first element
            if(front == -1)
                front = 0;

            //calculate next position of rear in the circular queue by using %size
            rear = (rear+1)%size;
            elements[rear] = data;
        }

        //dequeue
        public static int remove(){
            System.out.println("Request to remove ");
            //if queue is empty return -1
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            //get the element and front index to return
            int element = elements[front];

            //if there is only 1 element in array
            //since this is a circular queue, front will be moving indexes
            //Only when front and rear are same it means that there is only one element in queue
            if(front == rear){
                front = -1;
                rear = -1;
            } else {
                //increment front with circular queue logic
                front = (front+1)%size;
            }

            System.out.println("Removed " + element);
            return element;
        }

        public static int peek(){
            System.out.println("Request to peek");
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            System.out.println("Peek element is " + elements[front]);
            return elements[front];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(4);
        Queue.add(5);
        Queue.remove();
        Queue.add(5);
        Queue.remove();
        Queue.add(6);
        
        while(!Queue.isEmpty()){
            Queue.peek();
            Queue.remove();
        }

        Queue.isEmpty();
    }
}
