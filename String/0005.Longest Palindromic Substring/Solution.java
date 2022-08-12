class Solution {
    public String longestPalindrome(String s) {
        int mx = 0, mxL = 0, mxR = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l > 0 && s.charAt(l - 1) == s.charAt(i)) {
                l--;
            }
            while (r < n - 1 && s.charAt(r + 1) == s.charAt(i)) {
                r++;
            }
            while (l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }
            if (r - l + 1 > mx) {
                mx = r - l + 1;
                mxL = l;
                mxR = r;
            }
        }
        return s.substring(mxL, mxR + 1);
    }
}