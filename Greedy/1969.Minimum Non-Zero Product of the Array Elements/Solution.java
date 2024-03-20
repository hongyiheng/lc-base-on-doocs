class Solution {

    int MOD = (int)1e9 + 7;

    public long pow(long a, long b) {
        long ans = 1L, base = a % MOD;
        while (b-- > 0) {
            ans = ans * base % MOD;
            base = base * base % MOD;
        }
        return ans;
    }

    public int minNonZeroProduct(int p) {
        long k = (1L << p) -1;
        return (int)(k % MOD * pow(k - 1, p - 1) % MOD);
    }
}