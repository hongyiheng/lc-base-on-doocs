class Solution {
    public String longestNiceSubstring(String s) {
        String ans = new String();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > ans.length() && check(s.substring(i, j + 1))) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public boolean check(String s) {
        char[] chars = s.toCharArray();
        int[] up = new int[26];
        int[] low = new int[26];
        for (char c : chars) {
            if ('a' <= c && 'z' >= c) {
                low[c - 'a']++;
            } else {
                up[c - 'A']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (up[i] > 0 || low[i] > 0) {
                if (up[i] > 0 && low[i] > 0) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}