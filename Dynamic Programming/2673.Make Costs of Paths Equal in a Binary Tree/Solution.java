class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 1; i > 0; i -= 2) {
            int l = cost[i - 1], r = cost[i];
            ans += Math.abs(l - r);
            cost[(i - 1) / 2] += Math.max(l, r);
        }
        return ans;
    }
}