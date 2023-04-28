class DinnerPlates {

    PriorityQueue<Integer> addIds = new PriorityQueue<>((a, b) -> a - b);
    List<Deque<Integer>> q = new ArrayList<>();
    int cap;

    public DinnerPlates(int capacity) {
        cap = capacity;
    }

    public void push(int val) {
        int index = q.size();
        if (!addIds.isEmpty()) {
            index = addIds.poll();
        }
        if (index < q.size()) {
            q.get(index).addLast(val);
        } else {
            Deque<Integer> tmp = new ArrayDeque<>();
            tmp.addLast(val);
            q.add(tmp);
        }
        if (q.get(index).size() < cap) {
            addIds.add(index);
        }
    }

    public int pop() {
        return popAtStack(q.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= q.size() || q.get(index).isEmpty()) {
            return -1;
        }
        if (q.get(index).size() == cap) {
            addIds.add(index);
        }
        int ans = q.get(index).pollLast();
        while (!q.isEmpty() && q.get(q.size() - 1).isEmpty()) {
            q.remove(q.size() - 1);
        }
        return ans;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
