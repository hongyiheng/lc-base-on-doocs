class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int d = x * x + y * y;
                if (cnt.containsKey(d)) {
                    ans += cnt.get(d) * 2;
                }
                cnt.put(d, cnt.getOrDefault(d, 0) + 1);
            }
        }
        return ans;
    }
}