package CloneGraph133;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<Node> neighbors;

    // Constructor
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    // Add a neighbor (undirected edge)
    public void addNeighbor(Node neighbor) {
        if (!this.neighbors.contains(neighbor)) {
            this.neighbors.add(neighbor);
        }
    }

    // Print node and its neighbors for verification
    public void printNode() {
        System.out.print("Node " + val + " has neighbors: ");
        for (Node neighbor : neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();
    }
}
