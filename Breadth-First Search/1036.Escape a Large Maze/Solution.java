class Solution {
    int edge = (int)1e6, maxArea = 0;
    Set<Long> blockedSet = new HashSet<>();
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    long P = 131L;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        maxArea = n * n;
        for (int[] item : blocked) {
            blockedSet.add(item[0] * P + item[1]);
        }
        return bfs(source, target) && bfs(target, source);
    }

    public boolean bfs(int[] a, int[] b) {
        Deque<int[]> stk = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        stk.addLast(a);
        visited.add(a[0] * P + a[1]);
        while (!stk.isEmpty() && visited.size() <= maxArea) {
            int[] cur = stk.pollLast();
            if (cur[0] == b[0] && cur[1] == b[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= edge || y < 0 || y >= edge) {
                    continue;
                }
                long hashV = x * P + y;
                if (blockedSet.contains(hashV)) {
                    continue;
                }
                if (visited.contains(hashV)) {
                    continue;
                }
                visited.add(hashV);
                stk.addLast(new int[]{x, y});
            }
        }
        return visited.size() > maxArea;
    }
}