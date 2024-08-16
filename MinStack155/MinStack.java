package MinStack155;

import java.util.ArrayList;
import java.util.List;

// All functions run in O(1) time 
// Even the minimum one shown in the last
public class MinStack {
    private class Node {
        public int value;
        public int min;

        public Node(int value) {
            this.value = value;
        }
    }

    public List<Node> list;
    public int c = -1;

    public MinStack() {
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        var node = new Node(val);
        if (c == -1) {
            node.min = val;
        } else {
            var topNode = this.list.get(c);
            node.min = Math.min(val, topNode.min);
        }
        this.list.add(node);
        this.c++;
    }

    public void pop() {
        list.remove(c);
        this.c--;
    }

    public int top() {
        return this.list.get(c).value;
    }

    public int getMin() {
        return this.list.get(c).min;
    }
}
