class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, ans = 0;
        while (l < r) {
            ans = Math.max(nums[l++] + nums[r--], ans);
        }
        return ans;
    }
}