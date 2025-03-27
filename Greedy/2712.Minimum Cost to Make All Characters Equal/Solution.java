class Solution {

    public long f(String s, int t) {
        long ans = 0;
        int d = 0, n = s.length();
        for (int i = n / 2; i > -1; i--) {
            int v = s.charAt(i) - '0';
            if ((v ^ d) != t) {
                ans += i + 1;
                d ^= 1;
            }
        }
        d = 0;
        for (int i = n / 2; i < n; i++) {
            int v = s.charAt(i) - '0';
            if ((v ^ d) != t) {
                ans += n - i;
                d ^= 1;
            }
        }
        return ans;
    }

    public long minimumCost(String s) {
        return Math.min(f(s, 0), f(s, 1));
    }
}