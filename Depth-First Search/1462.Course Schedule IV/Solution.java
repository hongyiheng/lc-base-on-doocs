class Solution {

    Map<Integer, Set<Integer>> g, f;

    public Set<Integer> dfs(int v) {
        if (!g.containsKey(v)) {
            return Collections.emptySet();
        }
        if (f.containsKey(v)) {
            return f.get(v);
        }
        Set<Integer> ps = new HashSet<>();
        for (int p : g.get(v)) {
            ps.addAll(dfs(p));
        }
        g.get(v).addAll(ps);
        f.put(v, g.get(v));
        return g.get(v);
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        g = new HashMap<>();
        f = new HashMap<>();
        for (int[] e : prerequisites) {
            int p = e[0], v = e[1];
            g.computeIfAbsent(v, k -> new HashSet<>()).add(p);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(g.getOrDefault(q[1], new HashSet<>()).contains(q[0]));
        }
        return ans;
    }
}