import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class CreateQueueInJava {

    public static void main(String[] args) {
        //Queue<Integer> q = new LinkedList<>();
        //ArrayDeque is faster than LinkedList performance wise, related to caches etc.
        Queue<Integer> q = new ArrayDeque<>();
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
