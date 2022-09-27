class Solution {
    public String addBinary(String a, String b) {
        int n = a.length() - 1, m = b.length() - 1;
        String ans = "";
        boolean e = false;
        while (n >= 0 || m >= 0) {
            int cur = e ? 1 : 0;
            e = false;
            if (n >= 0 && a.charAt(n) == '1') {
                cur++;
            }
            if (m >= 0 && b.charAt(m) == '1') {
                cur++;
            }
            if (cur >= 2) {
                cur -= 2;
                e = true;
            }
            ans = String.valueOf(cur) + ans;
            m--;
            n--;
        }
        return e ? "1" + ans : ans;
    }
}
