class Solution {

    Map<String, Integer> f = new HashMap<>();
    int n;
    int[][] g;

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        g = grid;
        return dfs(0, -1);
    }

    public int dfs(int i, int j) {
        if (i == n) {
            return 0;
        }
        String key = i + ":" + j;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        List<int[]> q = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (k != j) {
                q.add(new int[]{g[i][k], k});
            }
        }
        q.sort(Comparator.comparingInt(a -> a[0]));
        int ans = Math.min(dfs(i + 1, q.get(0)[1]) + q.get(0)[0], dfs(i + 1, q.get(1)[1]) + q.get(1)[0]);
        f.put(key, ans);
        return ans;
    }
}