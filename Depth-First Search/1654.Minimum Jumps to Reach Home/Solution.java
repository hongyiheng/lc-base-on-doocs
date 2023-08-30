class Solution {

    Set<String> vis;
    Set<Integer> ban;
    int a, b, x;
    int inf = 0x3f3f3f3f;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        vis = new HashSet<>();
        ban = new HashSet<>();
        for (int v : forbidden) {
            ban.add(v);
        }
        this.a = a;
        this.b = b;
        this.x = x;
        int ans = dfs(0, 0);
        return ans >= inf ? -1 : ans;
    }

    public int dfs(int cur, int back) {
        if (cur == x) {
            return 0;
        }
        if (cur < 0 || cur > 6000) {
            return inf;
        }
        String k = cur + "_" + back;
        if (vis.contains(k) || ban.contains(cur)) {
            return inf;
        }
        vis.add(k);
        int ans = dfs(cur + a, 0);
        if (back == 0) {
            ans = Math.min(ans, dfs(cur - b, 1));
        }
        return ans + 1;
    }
}