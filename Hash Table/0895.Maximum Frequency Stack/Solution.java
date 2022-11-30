class FreqStack {

    Map<Integer, Integer> cnt;
    List<Deque<Integer>> stacks;

    public FreqStack() {
        cnt = new HashMap<>();
        stacks = new ArrayList<>();
    }

    public void push(int val) {
        int idx = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, idx);
        if (idx > stacks.size()) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(idx - 1).addLast(val);
    }

    public int pop() {
        int idx = stacks.size();
        int val = stacks.get(idx - 1).removeLast();
        if (stacks.get(idx - 1).isEmpty()) {
            stacks.remove(idx - 1);
        }
        cnt.put(val, idx - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
