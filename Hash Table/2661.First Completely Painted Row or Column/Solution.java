class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Integer> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.put(mat[i][j], i * n + j);
            }
        }
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m * n; i++) {
            int v = g.get(arr[i]);
            int x = v / n, y = v % n;
            if (++row[x] == n || ++col[y] == m) {
                return i;
            }
        }
        return -1;
    }
}