class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int v : nums) {
            if (v < k) {
                ans++;
            }
        }
        return ans;
    }
}