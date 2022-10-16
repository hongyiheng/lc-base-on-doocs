class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] color;

    public boolean dfs(int i, int c) {
        color[i] = c;
        for (int j : g.getOrDefault(i, new ArrayList<>())) {
            if (color[j] == c) {
                return false;
            }
            if (color[j] == -1 && !dfs(j, c ^ 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        for (int[] v : dislikes) {
            g.computeIfAbsent(v[0], k -> new ArrayList()).add(v[1]);
            g.computeIfAbsent(v[1], k -> new ArrayList()).add(v[0]);
        }
        color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i < n + 1; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
