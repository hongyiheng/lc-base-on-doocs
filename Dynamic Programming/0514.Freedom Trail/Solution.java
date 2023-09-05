class Solution {

    final int inf = 0x3f3f3f3f;

    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        Map<Character, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int[] f = new int[n];
        Arrays.fill(f, inf);
        for (int i : g.get(key.charAt(0))) {
            f[i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int v : g.get(key.charAt(i))) {
                int mi = inf;
                for (int u : g.get(key.charAt(i - 1))) {
                    mi = Math.min(mi, f[u] + Math.min(Math.abs(u - v), n - Math.abs(u - v)) + 1);
                }
                f[v] = mi;
            }
        }
        int ans = inf;
        for (int v : g.get(key.charAt(m - 1))) {
            ans = Math.min(ans, f[v]);
        }
        return ans;
    }
}