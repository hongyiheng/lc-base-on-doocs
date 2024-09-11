class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] f = new int[n + 1];
        int l = 0, r = 0, ans = 0;
        while (r < n) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            f[r + 1] = Math.max(f[r], r - l + 1);
            ans = Math.max(ans, r - l + 1 + f[l]);
            r++;
        }
        return ans;
    }
}