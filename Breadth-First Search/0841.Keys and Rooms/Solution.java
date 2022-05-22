class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int v : rooms.get(0)) {
            q.offer(v);
        }
        vis[0] = true;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            if (vis[cur]) {
                continue;
            }
            vis[cur] = true;
            for (int v : rooms.get(cur)) {
                q.offer(v);
            }
        }
        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}