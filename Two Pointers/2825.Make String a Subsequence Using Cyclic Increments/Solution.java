class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        if (m < n) {
            return false;
        }
        char[] s = str1.toCharArray(), t = str2.toCharArray();
        int j = 0;
        for (int i = 0; i < m; i++) {
            int a = s[i] - 'a', b = t[j] - 'a';
            if (a == b || (a + 1) % 26 == b % 26) {
                j++;
            }
            if (j == n) {
                return true;
            }
        }
        return false;
    }
}