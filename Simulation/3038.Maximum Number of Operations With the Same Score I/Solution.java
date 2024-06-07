class Solution {
    public int maxOperations(int[] nums) {
        int t = nums[0] + nums[1];
        int ans = 0;
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] + nums[i] != t) {
                break;
            }
            ans++;
        }
        return ans;
    }
}