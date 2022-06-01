class Solution {
    int t;
    boolean[] vis;
    int n;
    int[] matchsticks;

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        n = matchsticks.length;
        int mx = 0, all = 0;
        for (int v : matchsticks) {
            mx = Math.max(v, mx);
            all += v;
        }
        if (all % 4 != 0) {
            return false;
        }
        t = all / 4;
        if (mx > t) {
            return false;
        }
        Arrays.sort(matchsticks);
        vis = new boolean[n];
        return dfs(t, 4, n - 1);
    }

    public boolean dfs(int target, int k, int idx) {
        if (target == 0) {
            if (--k == 0) {
                return true;
            }
            return dfs(t, k, n -1);
        }
        for (int i = idx; i >= 0; i--) {
            if (matchsticks[i] > target || vis[i]) {
                continue;
            }
            vis[i] = true;
            if (dfs(target - matchsticks[i], k, idx - 1)) {
                return true;
            }
            vis[i] = false;
            if (target == t) {
                return false;
            }
        }
        return false;
    }
}