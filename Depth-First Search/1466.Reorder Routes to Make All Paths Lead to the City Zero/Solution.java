class Solution {

    Map<Integer, List<int[]>> g = new HashMap<>();

    public int dfs(int u, int p) {
        int ans = 0;
        for (int[] e : g.getOrDefault(u, new ArrayList<>())) {
            int v = e[0], w = e[1];
            if (v == p) {
                continue;
            }
            ans += w + dfs(v, u);
        }
        return ans;
    }

    public int minReorder(int n, int[][] connections) {
       for (int[] e : connections) {
           int u = e[0], v = e[1];
           g.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, 1});
           g.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, 0});
       }
       return dfs(0, -1);
    }
}