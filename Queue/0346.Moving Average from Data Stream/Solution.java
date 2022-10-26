class MovingAverage {

    Deque<Integer> q;
    int size;
    double s;

    public MovingAverage(int size) {
        q = new ArrayDeque<>();
        this.size = size;
        s = 0;
    }

    public double next(int val) {
        if (q.size() >= size) {
            s -= q.pollFirst();
        }
        q.addLast(val);
        s += val;
        return s == 0 ? 0 : s / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
