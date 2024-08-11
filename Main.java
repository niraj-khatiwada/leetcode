import java.util.*;
import CloneGraph133.GraphNode;
import CloneGraph133.CloneGraph133;

public class Main {
    public static void main(String[] args) {
        var one = new GraphNode(1);
        var two = new GraphNode(2);
        var three = new GraphNode(3);
        var four = new GraphNode(4);

        one.addNeighbor(two);
        one.addNeighbor(four);

        two.addNeighbor(one);
        two.addNeighbor(three);

        three.addNeighbor(two);
        three.addNeighbor(four);

        four.addNeighbor(one);
        four.addNeighbor(three);

        var clone = new CloneGraph133();
        clone.cloneGraph(one);
    }

}
