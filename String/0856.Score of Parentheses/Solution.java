class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, d = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                d++;
            } else {
                d--;
                if (s.charAt(i - 1) == '(') {
                    ans += 1 << d;
                }
            }
        }
        return ans;
    }
}
