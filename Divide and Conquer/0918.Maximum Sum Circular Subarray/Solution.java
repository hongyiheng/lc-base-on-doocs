class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = 0;
        int last = 0;
        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
            last = Math.max(i, last + i);
            max = Math.max(last, max);
        }
        last = 0;
        for (int j = 1; j < n - 1; j++) {
            last = Math.min(nums[j], last + nums[j]);
            min = Math.min(min, last);
        }
        int ans = Math.max(sum - min, max);
        return ans;
    }
}