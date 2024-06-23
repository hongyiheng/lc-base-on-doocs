class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        int ans = 0;
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>(Arrays.asList(x));
        q.add(x);
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int v = q.pollFirst();
                if (v == y) {
                    return ans;
                }
                for (int k : Arrays.asList(5, 11)) {
                    if (v % k == 0 && !vis.contains(v / k)) {
                        q.addLast(v / k);
                        vis.add(v / k);
                    }
                }
                for (int k : Arrays.asList(-1, 1)) {
                    if (!vis.contains(v + k)) {
                        q.addLast(v + k);
                        vis.add(v + k);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}