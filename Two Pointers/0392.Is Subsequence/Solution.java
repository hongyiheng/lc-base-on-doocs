class Solution {
    public boolean isSubsequence(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (sLen > tLen) {
            return false;
        }

        int left = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sLen; i++) {
            if (left == tLen) {
                return false;
            }
            while (tChars[left] != sChars[i]) {
                left++;
                if (left == tLen) {
                    return false;
                }
            }
            left++;
        }
        return true;
    }
}