class Solution {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[31];
        for (int i = 0; i < 31; i++) {
            for (int v : nums) {
                if ((v >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (cnt[i] >= k) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}