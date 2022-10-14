class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int)1e9 + 7;
        int[] tail = new int[26];
        for (char c : s.toCharArray()) {
            long cnt = 0;
            for (int v : tail) {
                cnt = (cnt + v) % mod;
            }
            tail[c - 'a'] = (int)cnt + 1;
        }
        long ans = 0;
        for (int v : tail) {
            ans = (ans + v) % mod;
        }
        return (int)ans;
    }
}
