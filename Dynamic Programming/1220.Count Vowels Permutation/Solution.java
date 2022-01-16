class Solution {
    public int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 2; k <= n; k++) {
            long na = (e + i + u) % mod;
            long ne = (a + i) % mod;
            long ni = (e + o) % mod;
            long no = i % mod;
            long nu = (i + o) % mod;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
}