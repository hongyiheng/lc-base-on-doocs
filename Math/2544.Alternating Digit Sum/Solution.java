class Solution {
    public int alternateDigitSum(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            int v = cs[i] - '0';
            ans += i % 2 == 0 ? v : -v;
        }
        return ans;
    }
}