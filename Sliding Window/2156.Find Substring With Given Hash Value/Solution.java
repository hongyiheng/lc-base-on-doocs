class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long cur = 0;
        long base = 1;
        for (int i = n - k; i < n; i++) {
            cur = cur + (s.charAt(i) - 'a' + 1) * base;
            base = base * power % modulo;
        }
        cur %= modulo;
        long lastPow = ksm(power, k - 1, modulo);
        int ans = n - k;
        for (int l = n - k - 1; l >= 0; l--) {
            cur = (cur - (s.charAt(l + k) - 'a' + 1) * lastPow % modulo + modulo) % modulo;
            cur = ((s.charAt(l) - 'a' + 1) % modulo + cur * power + modulo) % modulo;
            if (cur == hashValue) {
                ans = l;
            }
        }
        return s.substring(ans, ans + k);
    }

    public static long ksm(int a, int b, int m) {
        long ans = 1, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = ans * base % m;
            }
            base = base * base % m;
            b >>= 1;
        }
        return ans % m;
    }
}