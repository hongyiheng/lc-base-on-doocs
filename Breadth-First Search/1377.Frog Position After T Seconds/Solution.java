class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        vis.add(1);
        Deque<double[]> q = new ArrayDeque<>();
        q.addLast(new double[]{1, 1});
        while (!q.isEmpty() && t >= 0) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                double[] cur = q.pollFirst();
                int v = (int) cur[0];
                double w = cur[1];
                if (v == target && t == 0) {
                    return w;
                }
                List<Integer> tmp = new ArrayList<>();
                for (int nv : g.getOrDefault(v, new ArrayList<>())) {
                    if (!vis.contains(nv)) {
                        tmp.add(nv);
                        vis.add(nv);
                    }
                }
                if (tmp.isEmpty() && v == target) {
                    return w;
                }
                for (int nv : tmp) {
                    q.addLast(new double[]{nv, w / tmp.size()});
                }
            }
            t--;
        }
        return 0;
    }
}
