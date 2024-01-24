class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] pre = new long[n], suf = new long[n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[0] > v) {
                q.pollLast();
            }
            long s = 0, last = -1;
            for (int[] e : q) {
                s += (e[1] - last) * e[0];
                last = e[1];
            }
            q.add(new int[]{v, i});
            pre[i] = s + (i - last) * v;
        }
        q.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[0] > v) {
                q.pollLast();
            }
            long s = 0, last = n;
            for (int[] e : q) {
                s += (last - e[1]) * e[0];
                last = e[1];
            }
            q.add(new int[]{v, i});
            suf[i] = s + (last - i) * v;
        }
        long ans = Math.max(pre[n - 1], suf[0]);
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, pre[i] + suf[i + 1]);
        }
        return ans;
    }
}