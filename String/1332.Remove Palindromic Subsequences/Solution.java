class Solution {
    public int removePalindromeSub(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return 2;
            }
        }
        return 1;
    }
}