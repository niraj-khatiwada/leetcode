package DesignAStackWithIncrementOperation1381;

public class DesignAStackWithIncrementOperation {
    public int[] stack;
    public int p = -1;

    public DesignAStackWithIncrementOperation(int maxSize) {
        this.stack = new int[maxSize];
    }

    public void push(int x) {
        if (p == (stack.length - 1)) {
            return;
        }
        p++;
        this.stack[p] = x;
    }

    public int pop() {
        if (p == -1) {
            return -1;
        }
        var popped = stack[p];
        p--;
        return popped;
    }

    public void increment(int k, int val) {
        for (var i = 0; i < k; i++) {
            if (i > p) {
                break;
            }
            stack[i] += val;
        }
    }
}
