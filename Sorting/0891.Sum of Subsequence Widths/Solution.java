class Solution {
    public int sumSubseqWidths(int[] nums) {
        int mod = (int)1e9 + 7;
        int n = nums.length;
        long[] p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * 2L % mod;
        }
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (p[i] - p[n - i - 1]) * nums[i] % mod) % mod;
        }
        return (int)ans % mod;
    }
}
