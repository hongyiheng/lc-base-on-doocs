class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] cnt = new boolean[2001];
        for (int v : nums) {
            cnt[v] = true;
        }
        while (cnt[original]) {
            original *= 2;
        }
        return original;
    }
}