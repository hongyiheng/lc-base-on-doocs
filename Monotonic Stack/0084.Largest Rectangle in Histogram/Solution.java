class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = heights.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int v = heights[i];
            if (!q.isEmpty() && q.peekLast() > v) {
                int m = 1;
                while (!q.isEmpty() && q.peekLast() > v) {
                    int cur = q.pollLast();
                    ans = Math.max(ans, cur * m++);
                }
                for (int j = 0; j < m - 1; j++) {
                    q.addLast(v);
                }
            }
            q.addLast(v);
        }
        while (!q.isEmpty()) {
            ans = Math.max(ans, q.pollFirst() * (q.size() + 1));
        }
        return ans;
    }
}
