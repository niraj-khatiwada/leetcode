package FindMedianFromDataStream295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    public Queue<Integer> heapLeft;
    public Queue<Integer> heapRight;

    public FindMedianFromDataStream() {
        this.heapLeft = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        this.heapRight = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (!this.heapRight.isEmpty() && num > this.heapRight.peek()) {
            this.heapRight.offer(num);
        } else {
            this.heapLeft.offer(num);
        }

        if ((this.heapLeft.size() - this.heapRight.size()) > 1) {
            this.heapRight.offer(this.heapLeft.poll());
        }

        if ((this.heapRight.size() - this.heapLeft.size()) > 1) {
            this.heapLeft.offer(this.heapRight.poll());
        }
    }

    public double findMedian() {
        var sizeLeft = this.heapLeft.size();
        var sizeRight = this.heapRight.size();
        var peekLeft = this.heapLeft.peek();
        var peekRight = this.heapRight.peek();

        if (sizeLeft == sizeRight) {
            return ((double) peekLeft + peekRight) / 2;
        } else if (sizeLeft > sizeRight) {
            return peekLeft;
        } else {
            return peekRight;
        }
    }
}
