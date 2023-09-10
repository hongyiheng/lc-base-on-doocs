class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] to = new int[numCourses];
        for (int[] e : prerequisites) {
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
            to[e[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (to[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : g.getOrDefault(v, new ArrayList<>())) {
                if (--to[u] == 0) {
                    q.add(u);
                }
            }
            ans[cnt++] = v;
        }
        return cnt == numCourses ? ans : new int[0];
    }
}