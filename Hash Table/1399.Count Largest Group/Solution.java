class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int s = 0, v = i;
            while (v > 0) {
                s += v % 10;
                v /= 10;
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        int mx = 0;
        Map<Integer, Integer> g = new HashMap<>();
        for (int k : cnt.keySet()) {
            g.put(cnt.get(k), g.getOrDefault(cnt.get(k), 0) + 1);
            mx = Math.max(mx, cnt.get(k));
        }
        return g.get(mx);
    }
}