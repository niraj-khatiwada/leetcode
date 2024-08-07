import java.util.*;
import TaskScheduler621.TaskScheduler;

public class Main {
    public static void main(String[] args) {

        var task = new TaskScheduler();
        System.out.println(task.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

    }

}
