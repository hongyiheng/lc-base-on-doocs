class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]), buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] o : orders) {
            int v = o[0], c = o[1], t = o[2];
            if (t == 0) {
                while (c > 0 && !sell.isEmpty() && sell.peek()[0] <= v) {
                    int[] s = sell.poll();
                    if (s[1] > c) {
                        s[1] -= c;
                        c = 0;
                        sell.offer(s);
                    } else {
                        c -= s[1];
                    }
                }
                if (c > 0) {
                    buy.offer(new int[]{v, c});
                }
            } else {
                while (c > 0 && !buy.isEmpty() && buy.peek()[0] >= v) {
                    int[] b = buy.poll();
                    if (b[1] > c) {
                        b[1] -= c;
                        c = 0;
                        buy.offer(b);
                    } else {
                        c -= b[1];
                    }
                }
                if (c > 0) {
                    sell.offer(new int[]{v, c});
                }
            }
        }
        int mod = (int)1e9 + 7;
        long ans = 0;
        while (!sell.isEmpty()) {
            ans = (ans + sell.poll()[1]) % mod;
        }
        while (!buy.isEmpty()) {
            ans = (ans + buy.poll()[1]) % mod;
        }
        return (int)ans;
    }
}