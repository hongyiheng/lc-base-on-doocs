class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                l++;
            } else if (nums[i] == 2) {
                r--;
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = i < l ? 0 : (i > r ? 2 : 1);
        }
    }
}