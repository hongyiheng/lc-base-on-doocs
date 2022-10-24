class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int minVal = nums[0], minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIdx = i;
            }
        }
        int maxVal = 0;
        for (int i = 0; i < minIdx + 1; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int ans = minIdx + 1, nextMax = maxVal;
        for (int i = minIdx + 1; i < n; i++) {
            if (nums[i] < maxVal) {
                ans = i + 1;
                maxVal = nextMax;
            }
            nextMax = Math.max(nextMax, nums[i]);
        }
        return ans;
    }
}
