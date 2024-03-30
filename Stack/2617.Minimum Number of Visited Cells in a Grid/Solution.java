class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int inf = 0x3f3f3f3f;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, inf);
        }
        dist[0][0] = 1;
        List<PriorityQueue<int[]>> rows = new ArrayList<>();
        List<PriorityQueue<int[]>> cols = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rows.add(new PriorityQueue<>((a, b) -> a[0] - b[0]));
        }
        for (int j = 0; j < n; j++) {
            cols.add(new PriorityQueue<>((a, b) -> a[0] - b[0]));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                PriorityQueue<int[]> row = rows.get(i), col = cols.get(j);
                while (!row.isEmpty() && j > grid[i][row.peek()[1]] + row.peek()[1]) {
                    row.poll();
                }
                while (!col.isEmpty() && i > grid[col.peek()[1]][j] + col.peek()[1]) {
                    col.poll();
                }
                if (!row.isEmpty()) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][row.peek()[1]] + 1);
                }
                if (!col.isEmpty()) {
                    dist[i][j] = Math.min(dist[i][j], dist[col.peek()[1]][j] + 1);
                }
                row.add(new int[]{dist[i][j], j});
                col.add(new int[]{dist[i][j], i});
            }
        }
        return dist[m - 1][n - 1] >= inf ? -1 : dist[m - 1][n - 1];
    }
}