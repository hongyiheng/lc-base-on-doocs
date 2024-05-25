class Solution {

    public String check(String a, String b) {
        if ("".equals(a)) {
            return b;
        }
        if (a.length() != b.length()) {
            return a.length() > b.length() ? b : a;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) > b.charAt(i) ? b : a;
            }
        }
        return a;
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0, cnt = 0;
        String ans = "";
        for (int r = 0; r < s.length(); r++) {
            cnt += s.charAt(r) == '1' ? 1 : 0;
            while (cnt == k) {
                ans = check(ans, s.substring(l, r + 1));
                cnt -= s.charAt(l++) == '1' ? 1 : 0;
            }
        }
        return ans;
    }
}