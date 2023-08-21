class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] nxt = new int[n + 1];
        int x = 1, now = 0;
        while (x < n) {
            if (s.charAt(x) == s.charAt(now)) {
                x++;
                now++;
                nxt[x - 1] = now;
            } else if (now != 0) {
                now = nxt[now - 1];
            } else {
                x++;
                nxt[x - 1] = 0;
            }
        }
        return s.substring(0, nxt[n - 1]);
    }
}