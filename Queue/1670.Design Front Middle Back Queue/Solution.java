class FrontMiddleBackQueue {

    Deque<Integer> front, tail;

    public FrontMiddleBackQueue() {
        front = new ArrayDeque<>();
        tail = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        front.addFirst(val);
    }

    public void pushMiddle(int val) {
        balanceDeque();
        front.addLast(val);
    }

    public void pushBack(int val) {
        tail.addLast(val);
    }

    public int popFront() {
        if (tail.isEmpty() && front.isEmpty()) {
            return -1;
        }
        balanceDeque();
        return front.isEmpty() ? tail.pollFirst() : front.pollFirst();
    }

    public int popMiddle() {
        if (tail.isEmpty() && front.isEmpty()) {
            return -1;
        }
        balanceDeque();
        return front.size() == tail.size() ? front.pollLast() : tail.pollFirst();
    }

    public int popBack() {
        if (tail.isEmpty() && front.isEmpty()) {
            return -1;
        }
        balanceDeque();
        return tail.isEmpty() ? front.pollLast() : tail.pollLast();
    }

    public void balanceDeque() {
        while (front.size() < tail.size()) {
            front.addLast(tail.pollFirst());
        }
        while (tail.size() < front.size()) {
            tail.addFirst(front.pollLast());
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */