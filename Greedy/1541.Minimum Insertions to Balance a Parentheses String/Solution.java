class Solution {
    public int minInsertions(String s) {
        int ans = 0, l = 0, i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                int cnt = 1;
                while (i + 1 < n && s.charAt(i + 1) == ')') {
                    cnt++;
                    i++;
                }
                if (cnt % 2 != 0) {
                    cnt++;
                    ans++;
                }
                l -= cnt / 2;
                if (l < 0) {
                    ans += -l;
                    l = 0;
                }
            }
            i++;
        }
        if (l > 0) {
            ans += 2 * l;
        }
        return ans;
    }
}