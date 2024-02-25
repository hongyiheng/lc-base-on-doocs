class Solution {
    public int minOperations(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int v : nums) {
            for (int i = 0; i < 32; i++) {
                if ((v >> i & 1) == 1) {
                    cnt[i] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((k >> i & 1) == 1 && cnt[i] == 0) || ((k >> i & 1) == 0 && cnt[i] == 1)) {
                ans++;
            }
        }
        return ans;
    }
}