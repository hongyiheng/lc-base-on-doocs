class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            f[i] += f[i - 1];
            if (i >= 2) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}