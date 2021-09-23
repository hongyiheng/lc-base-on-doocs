class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dict = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            dict[i] = dict[i - 1] + i;
        }

        int diff = nums[1] - nums[0];
        int sonLen = 1;
        int ans = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                ++sonLen;
            } else {
                ans += dict[sonLen - 1];
                diff = nums[i] - nums[i - 1];
                sonLen = 1;
            }
        }
        ans += dict[sonLen - 1];
        return ans;
    }
}