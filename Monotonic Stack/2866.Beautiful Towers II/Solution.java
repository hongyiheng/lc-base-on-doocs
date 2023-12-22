class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        Deque<int[]> q = new ArrayDeque<>();
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int l = i, r = i, v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekLast()[1] > v) {
                int[] t = q.pollLast();
                l = t[0];
                pre[i + 1] -= (long) (r - l) * t[1];
                r = l;
            }
            pre[i + 1] += pre[i] + (long) (i - l + 1) * v;
            q.offerLast(new int[]{l, v});
        }

        q.clear();
        long[] tail = new long[n + 1];
        for (int i = n - 1; i > -1; i--) {
            int l = i, r = i, v = maxHeights.get(i);
            while (!q.isEmpty() && q.peekFirst()[1] > v) {
                int[] t = q.pollFirst();
                r = t[0];
                tail[i] -= (long) (r - l) * t[1];
                l = r;
            }
            tail[i] += tail[i + 1] + (long) (r - i + 1) * v;
            q.offerFirst(new int[]{r, v});
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre[i] + tail[i]);
        }
        return ans;
    }
}