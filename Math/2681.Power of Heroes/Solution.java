class Solution {
    public int sumOfPower(int[] nums) {
        int MOD = (int)1e9 + 7;
        Arrays.sort(nums);
        long ans = 0, s = 0;
        for (int v : nums) {
            ans = (ans + (1L * v * v % MOD) * (v + s)) % MOD;
            s = (2 * s + v) % MOD;
        }
        return (int)ans;
    }
}
