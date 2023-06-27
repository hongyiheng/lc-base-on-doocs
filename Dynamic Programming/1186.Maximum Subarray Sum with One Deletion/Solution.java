class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n + 1][2];
        for (int[] r : f) {
            Arrays.fill(r, -0x3f3f3f3f);
        }
        int ans = arr[0];
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], 0) + arr[i];
            f[i + 1][1] = Math.max(f[i][1] + arr[i], f[i][0]);
            ans = Math.max(ans, Math.max(f[i + 1][0], f[i + 1][1]));
        }
        return ans;
    }
}