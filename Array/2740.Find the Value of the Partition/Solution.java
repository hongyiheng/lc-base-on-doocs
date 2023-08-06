class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = 0x3f3f3f3f;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(nums[i] - nums[i - 1], ans);
        }
        return ans;
    }
}