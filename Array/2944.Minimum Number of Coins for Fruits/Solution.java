class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i / 2; j <= i; j++) {
                if (2 * j < i) {
                    continue;
                }
                f[i] = Math.min(f[i], f[j - 1] + prices[j - 1]);
            }
        }
        return f[n];
    }
}