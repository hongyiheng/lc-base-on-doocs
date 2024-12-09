class Solution {

    Map<String, Integer> f = new HashMap<>();

    public int dfs(int x, int y, int mask, int n, List<int[]> poss, int[][][] dis) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        String key = x + "_" + y + "_" + mask;
        if (f.get(key) != null) {
            return f.get(key);
        }
        int ans = 0;
        if (Integer.bitCount(mask) % 2 == 1) {
            for (int i = 1; i < n; i++) {
                if ((mask >> i & 1) == 0) {
                    ans = Math.max(ans, dfs(poss.get(i)[0], poss.get(i)[1], mask | (1 << i), n, poss, dis) + dis[i][x][y]);
                }
            }
        } else {
            ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if ((mask >> i & 1) == 0) {
                    ans = Math.min(ans, dfs(poss.get(i)[0], poss.get(i)[1], mask | (1 << i), n, poss, dis) + dis[i][x][y]);
                }
            }
        }
        f.put(key, ans);
        return ans;
    }

    public int maxMoves(int kx, int ky, int[][] positions) {
        List<int[]> poss = Arrays.stream(positions).collect(Collectors.toList());
        poss.add(0, new int[]{kx, ky});
        int n = poss.size();
        int[][][] dis = new int[n][50][50];
        for (int i = 0; i < n; i++) {
            int[][] d = dis[i];
            for (int[] r : d) {
                Arrays.fill(r, -1);
            }
            Deque<int[]> q = new ArrayDeque<>();
            q.add(poss.get(i));
            int step = 0;
            while (!q.isEmpty()) {
                step++;
                int m = q.size();
                for (int j = 0; j < m; j++) {
                    int[] pos = q.pollFirst();
                    int x = pos[0], y = pos[1];
                    for (int[] dir : new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}}) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || nx >= 50 || ny < 0 || ny >= 50) {
                            continue;
                        }
                        if (d[nx][ny] != -1) {
                            continue;
                        }
                        d[nx][ny] = step;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return dfs(kx, ky, 1, n, poss, dis);
    }
}