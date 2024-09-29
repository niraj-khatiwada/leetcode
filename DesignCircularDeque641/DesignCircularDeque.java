package DesignCircularDeque641;

public class DesignCircularDeque {

    public int[] queue;
    public int l;
    public int r;

    public DesignCircularDeque(int k) {
        this.queue = new int[k];
        l = -1;
        r = k;
    }

    public boolean insertFront(int value) {
        if ((l + 1) >= r) {
            return false;
        }
        l++;
        queue[l] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if ((r - 1) <= l) {
            return false;
        }
        r--;
        queue[r] = value;
        return true;
    }

    public boolean deleteFront() {
        if (l == -1 && r == queue.length) {
            return false;
        }
        if (l != -1) {
            queue[l] = 0;
            l--;
            return true;
        }
        var p = queue.length - 2;
        while (p >= r) {
            queue[p + 1] = queue[p];
            p--;
        }
        queue[r] = 0;
        r++;
        return true;
    }

    public boolean deleteLast() {
        if (l == -1 && r == queue.length) {
            return false;
        }
        if (r != queue.length) {
            queue[r] = 0;
            r++;
            return true;
        }
        var p = l - 1;
        var ref = queue[l];
        while (p >= 0) {
            var _ref = queue[p];
            queue[p] = ref;
            ref = _ref;
            p--;
        }
        queue[l] = 0;
        l--;
        return true;
    }

    public int getFront() {
        if (l == -1 && r == queue.length) {
            return -1;
        }
        if (l != -1) {
            return queue[l];
        }
        return queue[queue.length - 1];
    }

    public int getRear() {
        if (l == -1 && r == queue.length) {
            return -1;
        }
        if (r != queue.length) {
            return queue[r];
        }
        return queue[0];
    }

    public boolean isEmpty() {
        return l == -1 && r == queue.length;
    }

    public boolean isFull() {
        return (l + 1) == r;
    }
}