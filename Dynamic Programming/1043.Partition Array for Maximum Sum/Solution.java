class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n];
        int mx = 0;
        for (int i = 0; i < k; i++) {
            mx = Math.max(mx, arr[i]);
            f[i] = mx * (i + 1);
        }
        for (int i = k; i < n; i++) {
            mx = 0;
            for (int j = 0; j < k; j++) {
                mx = Math.max(mx, arr[i - j]);
                f[i] = Math.max(f[i], f[i - j - 1] + mx * (j + 1));
            }
        }
        return f[n - 1];
    }
}