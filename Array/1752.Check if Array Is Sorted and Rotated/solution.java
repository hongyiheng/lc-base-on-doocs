class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean turn = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (turn) {
                    return false;
                }
                turn = true;
            }
        }
        return !turn || nums[n - 1] <= nums[0];
    }
}
