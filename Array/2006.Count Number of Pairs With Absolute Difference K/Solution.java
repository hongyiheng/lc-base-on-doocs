class Solution {
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}