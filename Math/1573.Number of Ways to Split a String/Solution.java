class Solution {
    public int numWays(String s) {
        int cnt = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        if (cnt % 3 != 0) {
            return 0;
        }
        int t = cnt / 3, mod = (int)1e9 + 7;
        if (cnt == 0) {
            return (int)(1L * (n - 1) * (n - 2) / 2 % mod);
        }
        cnt = 0;
        int[] q = new int[]{0, 0};
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            } else {
                if (cnt == t) {
                    q[0]++;
                } else if (cnt == 2 * t) {
                    q[1]++;
                }
            }
        }
        return (int)(1L * (q[0] + 1) * (q[1] + 1) % mod);
    }
}