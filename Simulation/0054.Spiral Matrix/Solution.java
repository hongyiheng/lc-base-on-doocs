class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int dir = 0;
        int x = 0, y = 0;
        while (ans.size() < m * n) {
            while (!row.contains(x) && !col.contains(y)) {
                ans.add(matrix[x][y]);
                x += dirs[dir][0];
                y += dirs[dir][1];
                if (x < 0 || x >= m || y < 0 || y >= n || row.contains(x) || col.contains(y)) {
                    x -= dirs[dir][0];
                    y -= dirs[dir][1];
                    break;
                }
            }
            if (dirs[dir][0] == 0) {
                row.add(x);
            } else {
                col.add(y);
            }
            dir = dir == 3 ? 0 : dir + 1;
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        return ans;
    }
}