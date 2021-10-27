class Solution {
    int[] p;
    List<int[]> list = new ArrayList<>();
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (i < m - 1) {
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    list.add(new int[]{index, index + n, w});
                }
                if (j < n - 1) {
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    list.add(new int[]{index, index + 1, w});
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o[2]));
        int start = 0; int end = m * n - 1;
        for (int[] edge : list) {
            union(edge[0], edge[1]);
            if (find(start) == find(end)) {
                return edge[2];
            }
        }
        return 0;
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}