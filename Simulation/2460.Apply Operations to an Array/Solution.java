class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length, idx = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            ans[idx++] = nums[i];
        }
        return ans;
    }
}
