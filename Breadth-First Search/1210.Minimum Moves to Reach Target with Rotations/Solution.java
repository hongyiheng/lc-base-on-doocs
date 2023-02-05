class Solution {
    public int minimumMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 1, 0});
        Set<String> vis = new HashSet<>();
        vis.add("0,1,0");
        int ans = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] cur = q.pollFirst();
                int x = cur[0], y = cur[1], s = cur[2];
                if (x == m - 1 && y == n - 1 && s == 0) {
                    return ans;
                }
                // 水平
                if (s == 0) {
                    // 右
                    if (y + 1 < n && grid[x][y + 1] == 0) {
                        if (!vis.contains(x + "," + (y + 1) + ",0")) {
                            q.addLast(new int[]{x, y + 1, 0});
                            vis.add(x + "," + (y + 1) + ",0");
                        }
                    }
                    // 下
                    if (x + 1 < m && grid[x + 1][y] == 0 && grid[x + 1][y - 1] == 0) {
                        if (!vis.contains((x + 1) + "," + y + ",0")) {
                            q.addLast(new int[]{x + 1, y, 0});
                            vis.add((x + 1) + "," + y + ",0");
                        }
                        // 顺 90
                        if (!vis.contains((x + 1) + "," + (y - 1) + ",1")) {
                            q.addLast(new int[]{x + 1, y - 1, 1});
                            vis.add((x + 1) + "," + (y - 1) + ",1");
                        }
                    }
                } else {
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x - 1][y + 1] == 0) {
                        if (!vis.contains(x + "," + (y + 1) + ",1")) {
                            q.add(new int[]{x, y + 1, 1});
                            vis.add(x + "," + (y + 1) + ",1");
                        }
                        // 逆 90
                        if (!vis.contains((x - 1) + "," + (y + 1) + ",0")) {
                            q.addLast(new int[]{x - 1, y + 1, 0});
                            vis.add((x - 1) + "," + (y + 1) + ",0");
                        }
                    }

                    // 下
                    if (x + 1 < m && grid[x + 1][y] == 0) {
                        if (!vis.contains((x + 1) + "," + y + ",1")) {
                            q.addLast(new int[]{x + 1, y, 1});
                            vis.add((x + 1) + "," + y + ",1");
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}