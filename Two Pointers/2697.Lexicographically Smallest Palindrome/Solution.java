class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while (l < r) {
            cs[l] = cs[r] = (char)Math.min(cs[l], cs[r]);
            l++;
            r--;
        }
        return new String(cs);
    }
}