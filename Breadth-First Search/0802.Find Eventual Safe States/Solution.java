class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] cnt = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                g.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
                cnt[u]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            for (int v : g.getOrDefault(u, Collections.emptyList())) {
                cnt[v]--;
                if (cnt[v] == 0) {
                    q.addLast(v);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}