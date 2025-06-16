class Solution {

    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        int[][] rowPos = new int[n + 1][2];
        int[][] colPos = new int[n + 1][2];
        for (int[] pos : buildings) {
            int x = pos[0], y = pos[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);

            rowPos[x][0] = Math.min(rowPos[x][0] == 0 ? n : rowPos[x][0], y);
            rowPos[x][1] = Math.max(rowPos[x][1], y);

            colPos[y][0] = Math.min(colPos[y][0] == 0 ? n : colPos[y][0], x);
            colPos[y][1] = Math.max(colPos[y][1], x);
        }
        for (int[] pos : buildings) {
            int x = pos[0], y = pos[1];
            if (y == rowPos[x][0] || y == rowPos[x][1]) {
                continue;
            }
            if (x == colPos[y][0] || x == colPos[y][1]) {
                continue;
            }
            if (row.get(x) >= 3 && col.get(y) >= 3) {
                ans++;
            }
        }
        return ans;
    }

}