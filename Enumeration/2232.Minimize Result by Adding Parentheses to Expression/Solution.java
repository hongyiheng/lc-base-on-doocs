class Solution {
    public String minimizeResult(String expression) {
        String[] s = expression.split("\\+");
        String ans = "(" + expression + ")";
        int mi = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
        for (int i = 0; i < s[0].length(); i++) {
            for (int j = 1; j < s[1].length() + 1; j++) {
                String la = s[0].substring(0, i), lb = s[0].substring(i);
                String ra = s[1].substring(0, j), rb = s[1].substring(j);
                int a = i == 0 ? 1 : Integer.parseInt(la), b = Integer.parseInt(lb);
                int c = Integer.parseInt(ra), d = j == s[1].length() ? 1 : Integer.parseInt(rb);
                int v = a * (b + c) * d;
                if (v < mi) {
                    mi = v;
                    ans = la + "(" + lb + "+" + ra + ")" + rb;
                }
            }
        }
        return ans;
    }
}