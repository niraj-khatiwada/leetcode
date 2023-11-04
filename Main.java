import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.peek());

        Set<Character> set = new HashSet<>();
        set.add('1');
        set.contains('1');
        System.out.println(Integer.parseInt(String.valueOf('1')));
    }


}