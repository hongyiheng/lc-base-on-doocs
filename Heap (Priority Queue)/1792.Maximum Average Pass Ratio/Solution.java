class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> a[0] > b[0] ? -1 : 1);
        for (int[] v : classes) {
            q.add(new double[]{(double) (v[0] + 1) / (v[1] + 1) - (double) v[0] / v[1], v[0], v[1]});
        }
        while (extraStudents-- > 0) {
            double[] v = q.poll();
            v[1]++;
            v[2]++;
            q.add(new double[]{(double) (v[1] + 1) / (v[2] + 1) - (double) v[1] / v[2], v[1], v[2]});
        }
        double cnt = 0;
        while (!q.isEmpty()) {
            double[] v = q.poll();
            cnt += (double) v[1] / v[2];
        }
        return cnt / classes.length;
    }
}