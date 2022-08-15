class MyCircularDeque {
    Deque<Integer> q;
    int k;

    public MyCircularDeque(int k) {
        q = new ArrayDeque<>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (q.size() >= k) {
            return false;
        }
        q.addFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (q.size() >= k) {
            return false;
        }
        q.addLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (q.isEmpty()) {
            return false;
        }
        q.pollFirst();
        return true;
    }

    public boolean deleteLast() {
        if (q.isEmpty()) {
            return false;
        }
        q.pollLast();
        return true;
    }

    public int getFront() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekFirst();
    }

    public int getRear() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peekLast();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public boolean isFull() {
        return q.size() >= k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */