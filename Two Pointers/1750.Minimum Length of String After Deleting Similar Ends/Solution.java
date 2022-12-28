class Solution {
    public int minimumLength(String s) {
            int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            char c = s.charAt(l);
            while (l < r && s.charAt(l) == c) {
                l++;
            }
            while (r >= l && s.charAt(r) == c) {
                r--;
            }
        }
        return r - l + 1;
    }
}
