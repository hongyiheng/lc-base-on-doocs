class StockSpanner {

    Deque<int[]> q;
    int idx ;

    public StockSpanner() {
        q = new ArrayDeque<>();
        idx = 0;
    }

    public int next(int price) {
        while (!q.isEmpty() && q.peekLast()[1] <= price) {
            q.pollLast();
        }
        int l = q.isEmpty() ? -1 : q.peekLast()[0];
        int ans = idx - l;
        q.addLast(new int[]{idx, price});
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
