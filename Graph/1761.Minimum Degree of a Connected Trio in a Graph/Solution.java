class Solution {

    int inf = 0x3f3f3f3f;

    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            g.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int ans = inf;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (!g.get(i).contains(j)) {
                    continue;
                }
                for (int k = j + 1; k < n + 1; k++) {
                    if (!g.get(j).contains(k) || !g.get(k).contains(i)) {
                        continue;
                    }
                    ans = Math.min(ans, g.get(i).size() + g.get(j).size() + g.get(k).size() - 6);
                }
            }
        }
        return ans == inf ? -1 : ans;
    }
}