class Solution {
    public int[] singleNumber(int[] nums) {
        int twoNumBit = 0;
        for (int num : nums) {
            twoNumBit ^= num;
        }
        int lowBit = twoNumBit & -twoNumBit;
        int[] ans = new int[]{0, 0};
        for (int num : nums) {
            if ((num & lowBit) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}