class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[][] g = new boolean[26][26];
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            g[cs[i - 1] - 'a'][cs[i] - 'a'] = true;
        }
        for (int i = cs.length - 2; i > -1; i--) {
            if (g[cs[i + 1] - 'a'][cs[i] - 'a']) {
                return true;
            }
        }
        return false;
    }
}