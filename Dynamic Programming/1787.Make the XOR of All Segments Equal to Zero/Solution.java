class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length, m = 1 << 10;
        int[][] f = new int[k][m];
        int[] g = new int[k];
        for (int[] r : f) {
            Arrays.fill(r, 0x3f3f3f3f);
        }
        Arrays.fill(g, 0x3f3f3f3f);
        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            int s = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                s++;
            }
            if (i == 0) {
                for (int x = 0; x < m; x++) {
                    f[0][x] = Math.min(f[0][x], s - cnt.getOrDefault(x, 0));
                    g[0] = Math.min(g[0], f[0][x]);
                }
            } else {
                for (int x = 0; x < m; x++) {
                    f[i][x] = g[i - 1] + s;
                    for (int v : cnt.keySet()) {
                        f[i][x] = Math.min(f[i][x], f[i - 1][v ^ x] + s - cnt.get(v));
                        g[i] = Math.min(g[i], f[i][x]);
                    }
                }
            }
        }
        return f[k - 1][0];
    }
}