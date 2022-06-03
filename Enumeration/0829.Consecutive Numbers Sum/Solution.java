class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 1;
        for (int k = 2; k < n; k++) {
            int a = (2 * n / k - k + 1) / 2;
            if (a < 1) {
                break;
            } else if (n == (2 * a + k - 1) * k / 2) {
                ans++;
            }
        }
        return ans;
    }
}