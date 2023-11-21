class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int M = 100010;
        int[] cnt = new int[M];
        for (int v : nums) {
            cnt[Math.max(v - k, 0)]++;
            cnt[Math.min(v + k + 1, M - 1)]--;
        }
        int ans = 0, s = 0;
        for (int v : cnt) {
            s += v;
            ans = Math.max(ans, s);
        }
        return ans;
    }
}