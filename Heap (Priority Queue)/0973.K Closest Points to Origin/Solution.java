class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            q.offer(new int[]{dis, i});
        }
        int[][] ans = new int[k][2];
        while (k-- > 0) {
            ans[k] = points[q.poll()[1]];
        }
        return ans;
    }
}