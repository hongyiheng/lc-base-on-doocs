class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long maxNum = nums[i], minNum = nums[i];
            for (int j = i + 1; j < n; j++) {
                maxNum = Math.max(maxNum, nums[j]);
                minNum = Math.min(minNum, nums[j]);
                ans += maxNum - minNum;
            }
        }
        return ans;
    }
}