class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long ans = maximumHeight[n - 1];
        for (int i = n - 2; i > -1; i--) {
            maximumHeight[i] = Math.min(maximumHeight[i], maximumHeight[i + 1] - 1);
            if (maximumHeight[i] <= 0) {
                return -1L;
            }
            ans += maximumHeight[i];
        }
        return ans;
    }
}