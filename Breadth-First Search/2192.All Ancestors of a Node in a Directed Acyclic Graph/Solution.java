class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> g = new HashMap<>();

    public void bfs(int x) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        Set<Integer> vis = new HashSet<>();
        vis.add(x);
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            for (int v : g.getOrDefault(u, new ArrayList<>())) {
                if (vis.contains(v)) {
                    continue;
                }
                vis.add(v);
                q.offer(v);
                ans.get(v).add(x);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            bfs(i);
        }
        return ans;
    }
}