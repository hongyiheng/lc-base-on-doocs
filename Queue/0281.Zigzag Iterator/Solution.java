public class ZigzagIterator {
    Deque<Integer> q1;
    Deque<Integer> q2;
    boolean change = false;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        q1.addAll(v1);
        q2.addAll(v2);
    }

    public int next() {
        change = !change;
        if (!q1.isEmpty()) {
            if (!q2.isEmpty()) {
                return change ? q1.pollFirst() : q2.pollFirst();
            } else {
                return q1.pollFirst();
            }
        }
        return q2.pollFirst();
    }

    public boolean hasNext() {
        return !q1.isEmpty() || !q2.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */