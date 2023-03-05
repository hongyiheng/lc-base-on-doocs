class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int i = 0, n = customers.length;
        int up = 0, w = 0, mx = 0, ans = -1;
        while (i < n || w > 0) {
            if (i < n) {
                w += customers[i];
            }
            i++;
            up += Math.min(4, w);
            w -= Math.min(4, w);
            int cur = up * boardingCost - i * runningCost;
            if (cur > mx) {
                mx = cur;
                ans = i;
            }
        }
        return ans;
    }
}