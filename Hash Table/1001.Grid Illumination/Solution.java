class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {0, 0}, {-1, 1}, {1, -1}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> light = new HashSet<>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            int l = y - x, r = x + y;
            if (light.contains(x * n + y)) {
                continue;
            }
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            left.put(l, left.getOrDefault(l, 0) + 1);
            right.put(r, right.getOrDefault(r, 0) + 1);
            light.add(x * n + y);
        }
        int k = queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(y - x) || right.containsKey(x + y)) {
                ans[i] = 1;
            }
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (light.contains(nx * n + ny)) {
                    int nl = ny - nx, nr = nx + ny;
                    light.remove(nx * n + ny);
                    if (row.getOrDefault(nx, 0) > 1) {
                        row.put(nx, row.get(nx) - 1);
                    } else {
                        row.remove(nx);
                    }
                    if (col.getOrDefault(ny, 0) > 1) {
                        col.put(ny, col.get(ny) - 1);
                    } else {
                        col.remove(ny);
                    }
                    if (left.getOrDefault(nl, 0) > 1) {
                        left.put(nl, left.get(nl) - 1);
                    } else {
                        left.remove(nl);
                    }
                    if (right.getOrDefault(nr, 0) > 1) {
                        right.put(nr, right.get(nr) - 1);
                    } else {
                        right.remove(nr);
                    }
                }
            }
        }
        return ans;
    }
}