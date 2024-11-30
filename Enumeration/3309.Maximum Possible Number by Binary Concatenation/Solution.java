class Solution {
    public int maxGoodNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && i != k && j != k) {
                        int jLen = 32 - Integer.numberOfLeadingZeros(nums[j]);
                        int kLen = 32 - Integer.numberOfLeadingZeros(nums[k]);
                        int v = (nums[i] << (jLen + kLen)) + (nums[j] << kLen) + nums[k];
                        ans = Math.max(ans, v);
                    }
                }
            }
        }
        return ans;
    }
}