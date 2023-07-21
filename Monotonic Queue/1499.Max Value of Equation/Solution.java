class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        Deque<int[]> q = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            idx = Math.max(i + 1, idx);
            int x = points[i][0], y = points[i][1];
            while (!q.isEmpty() && q.peekFirst()[0] <= x) {
                q.pollFirst();
            }
            while (idx < n && points[idx][0] - x <= k) {
                while (!q.isEmpty() && q.peekLast()[0] + q.peekLast()[1] < points[idx][0] + points[idx][1]) {
                    q.pollLast();
                }
                q.addLast(new int[]{points[idx][0], points[idx][1]});
                idx++;
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, q.peekFirst()[0] - x + q.peekFirst()[1] + y);
            }
        }
        return ans;
    }
}