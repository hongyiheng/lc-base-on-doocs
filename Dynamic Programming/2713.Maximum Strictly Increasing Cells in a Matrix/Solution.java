class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        TreeMap<Integer, List<int[]>> g = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.computeIfAbsent(mat[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int[] rowMax = new int[m], colMax = new int[n];
        int ans = 0;
        for (int k : g.keySet()) {
            List<int[]> pos = g.get(k);
            int[] f = new int[pos.size()];
            for (int i = 0; i < pos.size(); i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                f[i] = Math.max(rowMax[x], colMax[y]) + 1;
                ans = Math.max(ans, f[i]);
            }
            for (int i = 0; i < pos.size(); i++) {
                int x = pos.get(i)[0], y = pos.get(i)[1];
                rowMax[x] = Math.max(rowMax[x], f[i]);
                colMax[y] = Math.max(colMax[y], f[i]);
            }
        }
        return ans;
    }
}