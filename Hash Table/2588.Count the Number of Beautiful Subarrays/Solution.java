class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        int[] cnt = new int[(int)1e6 * 2];
        cnt[0] = 1;
        for (int v : nums) {
            s ^= v;
            ans += cnt[s];
            cnt[s]++;
        }
        return ans;
    }
}