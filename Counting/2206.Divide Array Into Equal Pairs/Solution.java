class Solution {
    public boolean divideArray(int[] nums) {
        int[] cnt = new int[501];
        int t = nums.length / 2;
        for (int v : nums) {
            if (++cnt[v] >= 2) {
                cnt[v] -= 2;
                t--;
            }
        }
        return t == 0;
    }
}