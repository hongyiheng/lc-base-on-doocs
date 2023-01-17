class Solution {
    public static int findMinMoves(int[] machines) {
        int t = 0, n = machines.length;
        for (int v : machines) {
            t += v;
        }
        if (t % n != 0) {
            return -1;
        }
        int avg = t / n;
        int[] diff = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = machines[i] - avg;
            ans = Math.max(ans, diff[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                diff[i + 1] += diff[i];
            }
            ans = Math.max(ans, Math.abs(diff[i]));
        }
        return ans;
    }
}
