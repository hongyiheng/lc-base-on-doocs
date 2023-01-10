class Solution {
    int mod, k;
    Set<Integer> vis;
    List<Integer> ans;

    public String crackSafe(int n, int k) {
        this.k = k;
        mod = (int) Math.pow(10, n - 1);
        vis = new HashSet<>();
        ans = new ArrayList<>();
        dfs(0);
        for (int i = 0; i < n - 1; i++) {
            ans.add(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void dfs(int u) {
        for (int i = 0; i < k; i++) {
            int v = u * 10 + i;
            if (vis.contains(v)) {
                continue;
            }
            vis.add(v);
            dfs(v % mod);
            ans.add(i);
        }
    }
}