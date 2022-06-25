class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((i - ans) % 2 == 0 && nums[i] == nums[i + 1]) {
                ans++;
            }
        }
        return (n - ans) % 2 == 0 ? ans : ans + 1;
    }
}