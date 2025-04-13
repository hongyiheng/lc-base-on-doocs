class Solution {

    private long pow(long a, long b, int mod) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }

    public int countGoodNumbers(long n) {
        int mod = (int)1e9 + 7;
        return (int)(pow(5, (n + 1) / 2, mod) * pow(4, n / 2, mod) % mod);
    }
}