class Solution {
    int[] top;
    int t, ans;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        top = toppingCosts;
        t = target;
        ans = baseCosts[0];
        for (int b : baseCosts) {
            dfs(b, 0);
        }
        return ans;
    }

    public void dfs(int cur, int idx) {
        int a = Math.abs(t - cur), b = Math.abs(t - ans);
        if (a < b) {
            ans = cur;
        }
        if (a == b && cur < ans) {
            ans = cur;
        }
        if (cur > t) {
            return;
        }
        for (int i = idx; i < top.length; i++) {
            dfs(cur + top[i], i + 1);
            dfs(cur + 2 * top[i], i + 1);
        }
    }
}
