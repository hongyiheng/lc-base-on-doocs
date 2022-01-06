class Solution {
    List<List<Integer>> edges;
    Deque<Integer> stk = new ArrayDeque<>();
    int[] visited;
    boolean circle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] item : prerequisites) {
            edges.get(item[1]).add(item[0]);
        }
        for (int i = 0; i < numCourses && !circle; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (circle) {
            return new int[0];
        }
        int[] res = new int[stk.size()];
        int index = 0;
        while (!stk.isEmpty()) {
            res[index++] = stk.pollLast();
        }
        return res;
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (int j : edges.get(i)) {
            if (visited[j] == 0) {
                dfs(j);
                if (circle) {
                    return;
                }
            } else if (visited[j] == 1) {
                circle = true;
                return;
            }
        }
        visited[i] = 2;
        stk.addLast(i);
    }
}