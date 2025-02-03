class Solution {
    public boolean dfs(String s, int l, int r, boolean skip) {
        if (r - l + 1 <= 1) {
            return true;
        }
        if (r - l + 1 <= 2 && !skip) {
            return true;
        }
        if (s.charAt(l) != s.charAt(r)) {
            if (skip) {
                return false;
            }
            return dfs(s, l + 1, r, true) || dfs(s, l, r - 1, true);
        }
        return dfs(s, l + 1, r - 1, skip);
    }

    public boolean validPalindrome(String s) {
        return dfs(s, 0, s.length() - 1, false);
    }
}