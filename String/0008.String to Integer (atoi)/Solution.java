class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean neg = false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            neg = s.charAt(0) == '-';
            s = s.substring(1);
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) || ans >= (1L << 31)) {
                break;
            }
            ans = ans * 10 + s.charAt(i) - '0';
        }
        ans = neg ? Math.max(-ans, (-1L << 31)) : Math.min(ans, (1L << 31) - 1);
        return (int) ans;
    }
}