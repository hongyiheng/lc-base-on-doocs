class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return (nums[0] + nums[1]) % 10;
        }
        int[] ans = new int[n];
        int r = n - 1;
        while (r > 1) {
            for (int i = 0; i < r; i++) {
                ans[i] = (nums[i] + nums[i + 1]) % 10;
            }
            for (int i = 0; i < r; i++) {
                nums[i] = ans[i];
            }
            r--;
        }
        return (ans[0] + ans[1]) % 10;
    }
}