class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, ans = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] > (long)nums[l] * k) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return nums.length - ans;
    }
}