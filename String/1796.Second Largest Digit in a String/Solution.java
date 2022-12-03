class Solution {
    public int secondHighest(String s) {
        int mx = -1, ans = -1;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                int v = c - '0';
                if (mx < v) {
                    ans = mx;
                    mx = v;
                } else if (ans < v && v < mx) {
                    ans = v;
                }
            }
        }
        return ans;
    }
}
