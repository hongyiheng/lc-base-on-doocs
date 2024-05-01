class Solution {
   public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        if (n <= 2 * candidates) {
            Arrays.sort(costs);
            long s = 0;
            for (int i = 0; i < k; i++) {
                s += costs[i];
            }
            return s;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < candidates; i++) {
            if (i > n - i - 1) {
                break;
            }
            q.offer(new int[]{costs[i], i});
            if (i != n - i - 1) {
                q.offer(new int[]{costs[n - i - 1], n - i - 1});
            }
        }

        int l = candidates;
        int r = n - candidates - 1;
        long ans = 0;
        while (k > 0) {
            int[] e = q.poll();
            int v = e[0], i = e[1];
            if (l <= r) {
                if (i > r) {
                    q.offer(new int[]{costs[r], r});
                    r--;
                } else {
                    q.offer(new int[]{costs[l], l});
                    l++;
                }
            }
            ans += v;
            k--;
        }
        return ans;
    }
}