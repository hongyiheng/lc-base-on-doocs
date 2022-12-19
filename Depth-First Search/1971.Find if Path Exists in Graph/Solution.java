class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] e : edges) {
            mp.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            mp.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(source);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            if (u == destination) {
                return true;
            }
            if (vis.contains(u)) {
                continue;
            }
            vis.add(u);
            for (int v : mp.getOrDefault(u, new ArrayList<>())) {
                q.add(v);
            }
        }
        return false;
    }
}
