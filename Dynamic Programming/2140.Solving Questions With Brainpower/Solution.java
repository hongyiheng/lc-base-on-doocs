class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            f[i] = Math.max(f[i - 1], f[i]);
            int[] q = questions[i - 1];
            int j = Math.min(i + q[1], n);
            f[j] = Math.max(f[j], f[i - 1] + q[0]);
        }
        return f[n];
    }
}