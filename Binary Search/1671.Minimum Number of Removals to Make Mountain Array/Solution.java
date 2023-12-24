class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int idx = queryLowBound(q, v);
            if (idx == q.size()) {
                q.add(v);
            } else {
                q.set(idx, v);
            }
            pre[i] = idx + 1;
        }

        int ans = 0;
        q.clear();
        for (int i = n - 1; i > -1; i--) {
            int v = nums[i];
            int idx = queryLowBound(q, v);
            if (idx == q.size()) {
                q.add(v);
            } else {
                q.set(idx, v);
            }
            if (idx + 1 >= 2 && pre[i] >= 2) {
                ans = Math.max(ans, idx + pre[i]);
            }
        }
        return n - ans;
    }

    public int queryLowBound(List<Integer> q, int v) {
        if (q.isEmpty()) {
            return 0;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return q.get(r) < v ? r + 1 : r;
    }
}