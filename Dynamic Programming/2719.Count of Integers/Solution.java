class Solution {

    int mod = (int) 1e9 + 7;
    long[][] f = new long[24][401];
    int mi, mx;

    public long dfs(String s, int i, int cnt, boolean isLimit) {
        if (cnt > mx) {
            return 0;
        }
        if (i == s.length()) {
            return cnt >= mi ? 1 : 0;
        }
        if (!isLimit && f[i][cnt] != -1) {
            return f[i][cnt];
        }
        int up = isLimit ? s.charAt(i) - '0' : 9;
        long res = 0;
        for (int k = 0; k < up + 1; k++) {
            res = (res + dfs(s, i + 1, cnt + k, isLimit && k == up)) % mod;
        }
        if (!isLimit) {
            f[i][cnt] = res;
        }
        return res;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        mi = min_sum;
        mx = max_sum;
        for (long[] r : f) {
            Arrays.fill(r, -1);
        }
        long cnt1 = dfs(num2, 0, 0, true);
        for (long[] r : f) {
            Arrays.fill(r, -1);
        }
        long cnt2 = dfs(num1, 0, 0, true);
        long ans = (cnt1 - cnt2 + mod) % mod;
        long s = 0;
        for (char c : num1.toCharArray()) {
            s += c - '0';
        }
        ans += mi <= s && s <= mx ? 1 : 0;
        return (int)(ans % mod);
    }
}
