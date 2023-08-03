class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] ps = new int[n][2];
        for (int i = 0; i < n; i++) {
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        Arrays.sort(ps, Comparator.comparingInt(a -> a[0]));
        Deque<Double> q = new ArrayDeque<>();
        for (int i = n - 1; i > -1; i--) {
            double t = (target - ps[i][0]) * 1.0 / ps[i][1];
            if (q.isEmpty() || q.peekLast() < t) {
                q.addLast(t);
            }
        }
        return q.size();
    }
}