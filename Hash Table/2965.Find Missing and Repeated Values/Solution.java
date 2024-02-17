class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        Set<Integer> vis = new HashSet<>();
        for (int[] row : grid) {
            for (int v : row) {
                if (vis.contains(v)) {
                    ans[0] = v;
                }
                vis.add(v);
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!vis.contains(i)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}