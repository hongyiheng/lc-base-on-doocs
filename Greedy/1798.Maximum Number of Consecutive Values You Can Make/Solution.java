class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int ans = 1;
        Arrays.sort(coins);
        for (int v : coins) {
            if (v > ans) {
                break;
            }
            ans += v;
        }
        return ans;
    }
}