class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        long[] ans = new long[m];
        List<int[]> q = new ArrayList<>();
        long s = 0;
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, nums[i]});
            s += nums[i];
        }
        q.sort((a, b) -> a[1] != b[1] ?  a[1] - b[1] : a[0] - b[0]);
        Set<Integer> used = new HashSet<>();
        int idx = 0;
        for (int j = 0; j < m; j++) {
            int i = queries[j][0], k = queries[j][1];
            if (!used.contains(i)) {
                s -= nums[i];
                used.add(i);
            }
            while (k > 0 && idx < n) {
                if (used.contains(q.get(idx)[0])) {
                    idx++;
                    continue;
                }
                s -= q.get(idx)[1];
                used.add(q.get(idx)[0]);
                k--;
                idx++;
            }
            ans[j] = s;
        }
        return ans;
    }
}