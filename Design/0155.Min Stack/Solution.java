class MinStack {
    Deque<int[]> q;
    /** initialize your data structure here. */
    public MinStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        if (q.isEmpty()) {
            q.offer(new int[]{x, x});
        } else {
            q.offer(new int[]{x, Math.min(x, q.peekLast()[1])});
        }
    }

    public void pop() {
        q.pollLast();
    }

    public int top() {
        return q.peekLast()[0];
    }

    public int getMin() {
        return q.peekLast()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */