class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Set<Long> s = new HashSet<>(), vis = new HashSet<>();
        for (int[] e : coordinates) {
            s.add((long)e[0] * n + e[1]);
        }
        long[] ans = new long[5];
        for (int[] e : coordinates) {
            int x = e[0], y = e[1];
            for (int i = Math.max(0, e[0] - 1); i < Math.min(m - 1, x + 1); i++) {
                for (int j = Math.max(0, e[1] - 1); j < Math.min(n - 1, y + 1); j++) {
                    if (vis.contains((long)i * n + j)) {
                        continue;
                    }
                    vis.add((long)i * n + j);
                    int cnt = s.contains((long)i * n + j) ? 1 : 0;
                    cnt += s.contains((long)i * n + j + 1) ? 1 : 0;
                    cnt += s.contains((long)(i + 1) * n + j) ? 1 : 0;
                    cnt += s.contains((long)(i + 1) * n + j + 1) ? 1 : 0;
                    ans[cnt]++;
                }
            }
        }
        ans[0] = (long)(m - 1) * (n - 1) - vis.size();
        return ans;
    }
}