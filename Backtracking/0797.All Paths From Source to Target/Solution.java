class Solution {
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        n = graph.length;
        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(0);
        dfs(graph, path, 0);
        return ans;
    }

    public void dfs(int[][] graph, Deque<Integer> path, int cur) {
        if (cur == n - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            path.addLast(graph[cur][i]);
            dfs(graph, path, graph[cur][i]);
            path.removeLast();
        }
    }
}