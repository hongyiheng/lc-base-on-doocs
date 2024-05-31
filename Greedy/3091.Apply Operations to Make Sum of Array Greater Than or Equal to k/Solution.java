class Solution {
    public int minOperations(int k) {
        int ans = k - 1;
        for (int i = 1; i < k; i++) {
            ans = Math.min(ans, i - 1 + (k - 1) / i);
        }
        return ans;
    }
}