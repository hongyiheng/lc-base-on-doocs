class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int x = -1, y = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                x = i;
            } else if (nums[i] == n) {
                y = i;
            }
        }
        return x < y ? x + n - y - 1 : x + n - y - 2;
    }
}