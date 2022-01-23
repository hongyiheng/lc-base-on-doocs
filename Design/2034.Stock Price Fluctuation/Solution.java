class StockPrice {
    int cur;
    Map<Integer, Integer> mp;
    TreeMap<Integer, Integer> ts;

    public StockPrice() {
        cur = 0;
        mp = new HashMap<>();
        ts = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        cur = Math.max(cur, timestamp);
        if (mp.containsKey(timestamp)) {
            int old = mp.get(timestamp);
            int cnt = ts.get(old);
            if (cnt == 1) {
                ts.remove(old);
            } else {
                ts.put(old, cnt - 1);
            }
        }
        mp.put(timestamp, price);
        ts.put(price, ts.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return mp.get(cur);
    }

    public int maximum() {
        return ts.lastKey();
    }

    public int minimum() {
        return ts.firstKey();
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