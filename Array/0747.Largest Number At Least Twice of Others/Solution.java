class Solution {
    public int dominantIndex(int[] nums) {
        int a = 0, b = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
                ans = i;
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return a >= b * 2 ? ans : -1;
    }
}