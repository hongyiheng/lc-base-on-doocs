class Solution {

    public int[] getNxt(String s) {
        int n = s.length();
        int[] nxt = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                nxt[i++] = ++j;
            } else if (j != 0) {
                j = nxt[j - 1];
            } else {
                i++;
            }
        }
        return nxt;
    }

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int[] nxt = getNxt(s + "#" + rev);
        return rev.substring(0, s.length() - nxt[nxt.length - 1]) + s;
    }
}