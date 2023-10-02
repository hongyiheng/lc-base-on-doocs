class Solution {
    public int maxProfit(int[] prices) {
        int f0 = 0, f1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = f0;
            f0 = Math.max(f0, f1 + prices[i]);
            f1 = Math.max(f1, tmp - prices[i]);
        }
        return Math.max(f0, f1);
    }
}