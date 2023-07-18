class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> ins = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int idx = 0;
        for (int[] q : qs) {
            int v = q[0], i = q[1];
            while (idx < n && intervals[idx][0] <= v) {
                int l = intervals[idx][0], r = intervals[idx][1];
                ins.add(new int[]{r - l + 1, r});
                idx++;
            }
            while (!ins.isEmpty() && ins.peek()[1] < v) {
                ins.poll();
            }
            if (!ins.isEmpty()) {
                ans[i] = ins.peek()[0];
            }
        }
        return ans;
    }
}