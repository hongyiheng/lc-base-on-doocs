class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            boolean same = true;
            for (char c : w.toCharArray()) {
                if (!s[c - 'a']) {
                    same = false;
                    break;
                }
            }
            if (same) {
                ans += 1;
            }
        }
        return ans;
    }
}
