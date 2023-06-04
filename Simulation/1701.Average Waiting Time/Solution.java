class Solution {
    public double averageWaitingTime(int[][] customers) {
        long cnt = 0, cur = 0, n = customers.length;
        for (int i = 0; i < n; i++) {
            cur = Math.max(cur, customers[i][0]) + customers[i][1];
            cnt += cur - customers[i][0];
        }
        return 1.0 * cnt / n;
    }
}