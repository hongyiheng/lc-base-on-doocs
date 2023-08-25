class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        Deque<int[]> q = new ArrayDeque<>();
        for (int[] e : restrictions) {
            while (!q.isEmpty() && e[1] < q.peekLast()[1] && q.peekLast()[1] - e[1] > e[0] - q.peekLast()[0]) {
                q.pollLast();
            }
            q.addLast(e);
        }
        int x = 1, y = 0, ans = 0;
        while (x < n) {
            while (!q.isEmpty() && q.peek()[0] <= x) {
                q.poll();
            }
            int nx = q.isEmpty() ? n : q.peek()[0];
            int ny = q.isEmpty() ? n : Math.min(q.peek()[1], nx - x + y);
            int l = y, r = nx - x + y;
            while (l < r) {
                int mid = (l + r + 1) >>> 1;
                if (mid - y + mid - ny > nx - x) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            ans = Math.max(ans, l);
            x = nx;
            y = ny;
        }
        return ans;
    }
}