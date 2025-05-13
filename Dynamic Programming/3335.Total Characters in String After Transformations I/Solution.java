class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = (int)1e9 + 7;
        long[][] f = new long[t + 1][26];
        for (char c : s.toCharArray()) {
            f[0][c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            f[i + 1][0] = f[i][25];
            f[i + 1][1] = (f[i][25] + f[i][0]) % mod;
            for (int j = 2; j < 26; j++) {
                f[i + 1][j] = f[i][j - 1];
            }
        }
        return (int)(Arrays.stream(f[t]).sum() % mod);
    }
}