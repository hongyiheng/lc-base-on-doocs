class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int l = 0, r = n, idx = 0;
        while (idx < 2 * n) {
            ans[idx] = nums[l++];
            ans[idx + 1] = nums[r++];
            idx += 2;
        }
        return ans;
    }
}