class Solution {
    public int unequalTriplets(int[] nums) {
        int[] cnt = new int[1010];
        for (int v : nums) {
            cnt[v]++;
        }
        int l = 0, r = nums.length, ans = 0;
        for (int v : cnt) {
            r -= v;
            ans += l * r * v;
            l += v;
        }
        return ans;
    }
}
