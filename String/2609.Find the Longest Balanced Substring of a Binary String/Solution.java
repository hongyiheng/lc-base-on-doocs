class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int a = 0, b = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (b > 0) {
                    a = 0;
                    b = 0;
                }
                a++;
            } else {
                b++;
                ans = Math.max(ans, 2 * Math.min(a, b));
            }
        }
        return ans;
    }
}