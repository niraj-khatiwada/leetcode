import java.util.PriorityQueue;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }


}