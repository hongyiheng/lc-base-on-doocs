class Solution {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int mod = (int)1e9 + 7;
        long[][] f = new long[Math.max(n, 4) + 1][2];
        f[0][0] = f[0][1] = 1;
        f[1][0] = f[1][1] = 1;
        f[2][0] = f[2][1] = 2;
        f[3][0] = f[3][1] = 4;
        for (int i = 4; i < n + 1; i++) {
            f[i][0] = (f[i - 1][0] + f[i - 2][0] + f[i - 3][0]) % mod;
            f[i][1] = (f[i - 1][1] + f[i - 2][1] + f[i - 3][1] + f[i - 4][1]) % mod;
        }

        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = pressedKeys.charAt(i);
            cnt++;
            if (i == n - 1 || c != pressedKeys.charAt(i + 1)) {
                ans = ans * (c == '7' || c == '9' ? f[cnt][1] : f[cnt][0]) % mod;
                cnt = 0;
            }
        }
        return (int)ans;
    }
}