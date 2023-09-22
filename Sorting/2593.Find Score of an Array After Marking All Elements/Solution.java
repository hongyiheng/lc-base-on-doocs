class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i] = new int[]{nums[i], i};
        }
        Arrays.sort(q, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        boolean[] used = new boolean[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int v = q[i][0], k = q[i][1];
            if (used[k]) {
                continue;
            }
            for (int j = Math.max(0, k - 1); j < Math.min(n, k + 2); j++) {
                used[j] = true;
            }
            ans += v;
        }
        return ans;
    }
}