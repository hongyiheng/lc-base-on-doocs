class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1;
        int[] ans = new int[nums.length];
        for (int v : nums) {
            if (v % 2 == 0) {
                ans[i] = v;
                i += 2;
            } else {
                ans[j] = v;
                j += 2;
            }
        }
        return ans;
    }
}