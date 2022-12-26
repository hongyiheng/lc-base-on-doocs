class Solution {
    public int countHomogenous(String s) {
        int ans = 1, k = 1, mod = (int)1e9 + 7;
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            if (cs[i - 1] == cs[i]) {
                k++;
            } else {
                k = 1;
            }
            ans = (ans + k) % mod;
        }
        return ans % mod;
    }
}