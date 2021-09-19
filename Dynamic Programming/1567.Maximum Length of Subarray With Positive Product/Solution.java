class Solution {
    public int getMaxLen(int[] nums) {
        int ans = 0, lastMax = 0, lastMin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastMax = 0;
                lastMin = 0;
            }
            if (nums[i] > 0) {
                lastMax = lastMax + 1;
                lastMin = lastMin == 0 ? 0 : lastMin + 1;
            }
            if (nums[i] < 0) {
                int temp = lastMax;
                lastMax = lastMin == 0 ? 0 : lastMin + 1;
                lastMin = temp + 1;
            }
            ans = Math.max(ans, lastMax);
        }
        return ans;
    }
}