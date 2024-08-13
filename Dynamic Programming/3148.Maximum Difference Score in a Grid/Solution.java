class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] f = new int[m + 1][n + 1];
        int inf = 0x3f3f3f3f;
        for(int[] r : f) {
            Arrays.fill(r, inf);
        }
        int ans = -inf;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int v = grid.get(i - 1).get(j - 1);
                int mi = Math.min(f[i][j - 1], f[i - 1][j]);
                ans = Math.max(ans, v - mi);
                f[i][j] = Math.min(mi, v);
            }
        }
        return ans;
    }
}