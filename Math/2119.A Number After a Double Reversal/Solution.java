class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        String s = String.valueOf(num);
        int n = s.length();
        int cur = 1, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (ans == 0 && s.charAt(i) == '0') {
                return false;
            }
            ans += cur * (s.charAt(i) - '0');
            cur *= 10;
        }
        return String.valueOf(ans).charAt(n - 1) != '0';
    }
}