class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, i = 0;
        int mx = -1;
        while (i < n) {
            if (i < n - 1 && nums[i] > nums[i + 1]) {
                if (mx > nums[i + 1]) {
                    return false;
                }
                mx = nums[i];
                i++;
            } else {
                if (mx > nums[i]) {
                    return false;
                }
                mx = nums[i];
            }
            i++;
        }
        return true;
    }
}
