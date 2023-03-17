class Solution {
    public List<Integer> topoSort(int k, int[][] arr) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] ind = new int[k];
        for (int[] e : arr) {
            int u = e[0] - 1, v = e[1] - 1;
            g.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            ind[v]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            ans.add(u);
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (--ind[v] == 0) {
                    q.add(v);
                }
            }
        }
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row = topoSort(k, rowConditions);
        List<Integer> col = topoSort(k, colConditions);
        if (row.size() != k || col.size() != k) {
            return new int[][]{};
        }
        int[] pos = new int[k];
        for (int i = 0; i < k; i++) {
            pos[col.get(i)] = i;
        }
        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            ans[i][pos[row.get(i)]] = row.get(i) + 1;
        }
        return ans;
    }
}
