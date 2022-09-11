class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ds = new double[n][2];
        for (int i = 0; i < n; i++) {
            ds[i][0] = wage[i] * 1.0 / quality[i] * 1.0;
            ds[i][1] = quality[i] * 1.0;
        }
        Arrays.sort(ds, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        double ans = Double.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (int)ds[i][1];
            q.add((int)ds[i][1]);
            if (q.size() > k) {
                cnt -= q.poll();
            }
            if (q.size() == k) {
                ans = Math.min(ans, cnt * ds[i][0]);
            }
        }
        return ans;
    }
}