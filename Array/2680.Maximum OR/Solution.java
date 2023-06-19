class Solution {
    public long maximumOr(int[] nums, int k) {
        int[] cnt = new int[50];
        for (int v : nums) {
            for (int i = 30; i > -1; i--) {
                if ((v >> i & 1) != 0) {
                    cnt[i]++;
                }
            }
        }
        long ans = nums[0];
        for (int v : nums) {
            for (int i = 30; i > -1; i--) {
                if ((v >> i & 1) != 0) {
                    cnt[i]--;
                    cnt[i + k]++;
                }
            }
            long cur = 0;
            for (int i = 0; i < 50; i++) {
                if (cnt[i] > 0) {
                    cur |= (1L << i);
                }
            }
            ans = Math.max(cur, ans);
            for (int i = 30; i > -1; i--) {
                if ((v >> i & 1) != 0) {
                    cnt[i]++;
                    cnt[i + k]--;
                }
            }
        }
        return ans;
    }
}
