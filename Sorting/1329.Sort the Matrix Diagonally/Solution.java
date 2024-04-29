class Solution {

    int m, n;

    public void reset(int[][] mat, int i, int j) {
        List<Integer> q = new ArrayList<>();
        int x = i, y = j;
        while (x < m && y < n) {
            q.add(mat[x++][y++]);
        }
        Collections.sort(q, (a, b) -> a - b);
        x = i;
        y = j;
        int idx = 0;
        while (x < m && y < n) {
            mat[x++][y++] = q.get(idx++);
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 1; i < m; i++) {
            reset(mat, i, 0);
        }
        for (int j = 0; j < n; j++) {
            reset(mat, 0, j);
        }
        return mat;
    }
}