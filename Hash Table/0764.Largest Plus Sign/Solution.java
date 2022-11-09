class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<String> g = new HashSet<>();
        Map<Integer, List<int[]>> row = new HashMap<>(), col = new HashMap<>();
        for (int[] v : mines) {
            g.add(v[0] + "," + v[1]);
            row.computeIfAbsent(v[0], k -> new ArrayList<>()).add(new int[]{v[0], v[1]});
            col.computeIfAbsent(v[1], k -> new ArrayList<>()).add(new int[]{v[0], v[1]});
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g.contains(i + "," + j)) {
                    continue;
                }
                int r = Math.min(j + 1, n - j), c = Math.min(i + 1, n - i);
                List<int[]> rs = row.getOrDefault(i, null), cs = col.getOrDefault(j, null);
                if (rs != null) {
                    for (int[] v : rs) {
                        r = Math.min(Math.abs(v[1] - j), r);
                    }
                }
                if (cs != null) {
                    for (int[] v : cs) {
                        c = Math.min(Math.abs(v[0] - i), c);
                    }
                }
                ans = Math.max(ans, Math.min(r, c));
            }
        }
        return ans;
    }
}
