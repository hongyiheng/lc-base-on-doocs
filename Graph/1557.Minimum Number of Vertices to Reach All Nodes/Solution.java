class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> vis = new HashSet();
        for (List<Integer> e : edges) {
            int v = e.get(1);
            vis.add(v);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}