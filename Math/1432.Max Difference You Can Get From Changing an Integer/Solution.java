class Solution {
    public int maxDiff(int num) {
        int a = -1, b = -1, av = -1, bv = -1;
        int mx = 0, mi = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - '0';
            if (i == 0 && v != 1 && b == -1) {
                b = v;
                bv = 1;
            }
            if (i > 0 && v > 0 && s.charAt(i) != s.charAt(0) && b == -1) {
                b = v;
                bv = 0;
            }
            if (v != 9 && a == -1) {
                a = v;
                av = 9;
            }
            mx = mx * 10 + (v == a ? av : v);
            mi = mi * 10 + (v == b ? bv : v);
        }
        return mx - mi;
    }
}