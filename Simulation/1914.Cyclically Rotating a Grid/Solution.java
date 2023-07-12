class Solution {

    int[][] grid;
    int k;

    public void rotate(int x1, int y1, int x2, int y2) {
        List<Integer> q = new ArrayList<>();
        for (int j = y1; j <= y2; j++) {
            q.add(grid[x1][j]);
        }
        for (int i = x1 + 1; i < x2; i++) {
            q.add(grid[i][y2]);
        }
        for (int j = y2; j >= y1; j--) {
            q.add(grid[x2][j]);
        }
        for (int i = x2 - 1; i > x1; i--) {
            q.add(grid[i][y1]);
        }
        int n = q.size();
        int idx = k % n;
        for (int j = y1; j <= y2; j++) {
            grid[x1][j] = q.get(idx++ % n);
        }
        for (int i = x1 + 1; i < x2; i++) {
            grid[i][y2] = q.get(idx++ % n);
        }
        for (int j = y2; j >= y1; j--) {
            grid[x2][j] = q.get(idx++ % n);
        }
        for (int i = x2 - 1; i > x1; i--) {
            grid[i][y1] = q.get(idx++ % n);
        }
    }


    public int[][] rotateGrid(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        int x1 = 0, y1 = 0, x2 = grid.length - 1, y2 = grid[0].length - 1;
        while (x1 < x2 && y1 < y2) {
            rotate(x1, y1, x2, y2);
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return grid;
    }
}