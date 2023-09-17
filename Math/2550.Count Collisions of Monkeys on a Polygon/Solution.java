class Solution {
    public int monkeyMove(int n) {
        long ans = 1, base = 2;
        int mod = (int)1e9 + 7;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = ans * base % mod;
            }
            base = base * base % mod;
            n >>= 1;
        }
        return ((int)ans - 2 + mod) % mod;
    }
}