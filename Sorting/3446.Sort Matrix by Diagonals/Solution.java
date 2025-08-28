class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }
        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            if (e.getKey() < 0) {
                e.getValue().sort(Collections.reverseOrder());
            } else {
                Collections.sort(e.getValue());
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> r = g.get(i - j);
                grid[i][j] = r.remove(r.size() - 1);
            }
        }
        return grid;
    }
}