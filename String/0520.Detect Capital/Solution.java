class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) {
            return true;
        }
        char[] cs = word.toCharArray();
        if ('a' <= cs[0] && cs[0] <= 'z') {
            for (char c : cs) {
                if ('a' <= c && c <= 'z') {
                    continue;
                }
                return false;
            }
        } else if ('a' <= cs[1] && cs[1] <= 'z') {
            for (int i = 1; i < n; i++) {
                if ('a' <= cs[i] && cs[i] <= 'z') {
                    continue;
                }
                return false;
            }
        } else {
            for (char c : cs) {
                if ('A' <= c && c <= 'Z') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}