class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        return (s + s).substring(1, 2 * n - 1).indexOf(s) != -1;
    }
}