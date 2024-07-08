class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int s = 0, t = 0;
        for (int v : nums) {
            s += v;
        }
        for (int i = 0; i < n; i++) {
            if ((s - nums[i]) % 2 == 0 && t == (s - nums[i]) / 2) {
                return i;
            }
            t += nums[i];
        }
        return -1;
    }
}