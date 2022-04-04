class Solution {
    public int maxProfit(int[] prices) {
        int lastMin = Integer.MAX_VALUE, ans = 0;
        for (int price : prices) {
            ans = Math.max(ans, price - lastMin);
            lastMin = Math.min(lastMin, price);
        }
        return ans;
    }
}