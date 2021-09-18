class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, lastMax = 1, lastMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = lastMax;
                lastMax = lastMin;
                lastMin = temp;
            }
            lastMax = Math.max(nums[i] * lastMax, nums[i]);
            lastMin = Math.min(nums[i] * lastMin, nums[i]);
            ans = Math.max(ans, lastMax);
        }
        return ans;
    }
}