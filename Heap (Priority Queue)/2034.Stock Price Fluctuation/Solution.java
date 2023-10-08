class StockPrice {

    Map<Integer, Integer> g;
    PriorityQueue<int[]> max, mi;
    int cur;

    public StockPrice() {
        cur = -1;
        g = new HashMap<>();
        max = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        mi = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    }

    public void update(int timestamp, int price) {
        g.put(timestamp, price);
        max.add(new int[]{price, timestamp});
        mi.add(new int[]{price, timestamp});
        if (timestamp > cur) {
            cur = timestamp;
        }
    }

    public int current() {
        return g.get(cur);
    }

    public int maximum() {
        while (!max.isEmpty() && g.get(max.peek()[1]) != max.peek()[0]) {
            max.poll();
        }
        return max.peek()[0];
    }

    public int minimum() {
        while (!mi.isEmpty() && g.get(mi.peek()[1]) != mi.peek()[0]) {
            mi.poll();
        }
        return mi.peek()[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */