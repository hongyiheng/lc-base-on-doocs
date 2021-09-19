class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int lastMax = prices[len - 1], ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            ans = Math.max(ans, lastMax - prices[i]);
            lastMax = Math.max(lastMax, prices[i]);
        }
        return ans;
    }
}