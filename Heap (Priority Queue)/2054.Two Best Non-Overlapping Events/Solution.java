class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0, mx = 0;
        for (int[] e : events) {
            int u = e[0], v = e[1], w = e[2];
            while (!q.isEmpty() && q.peek()[0] < u) {
                mx = Math.max(mx, q.poll()[1]);
            }
            ans = Math.max(ans, mx + w);
            q.offer(new int[]{v, w});
        }
        return ans;
    }
}