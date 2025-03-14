class Solution {
    public boolean isBalanced(String num) {
        char[] cs = num.toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                ans += cs[i] - '0';
            } else {
                ans -= (cs[i] - '0');
            }
        }
        return ans == 0;
    }
}