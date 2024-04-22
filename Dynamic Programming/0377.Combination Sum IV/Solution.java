class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int v : nums) {
                if (i < v) {
                    continue;
                }
                f[i] += f[i - v];
            }
        }
        return f[target];
    }
}