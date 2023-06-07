class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        if (n <= 1) {
            return n;
        }
        String s1 = "", s2 = "";
        int l = 0, r = n - 1;
        while (l < r) {
            s1 += text.charAt(l);
            s2 = text.charAt(r) + s2;
            if (s1.equals(s2)) {
                return 2 + longestDecomposition(text.substring(l + 1, r));
            }
            l++;
            r--;
        }
        return 1;
    }
}
