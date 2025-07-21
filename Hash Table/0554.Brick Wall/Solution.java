class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size(), n = wall.get(0).stream().mapToInt(e->e).sum();
        Map<Integer, Integer> interval = new HashMap<>();
        for (List<Integer> row : wall) {
            int s = 0;
            for (int v : row) {
                s += v;
                if (s == n) {
                    continue;
                }
                interval.put(s, interval.getOrDefault(s, 0) + 1);
            }
        }
        int ans = m;
        for (int v : interval.values()) {
            ans = Math.min(ans, m - v);
        }
        return ans;
    }
}