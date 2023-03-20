class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length(), offset = 0;
        char[] cs = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            offset = (offset + shifts[i]) % 26;
            cs[i] = (char) ((cs[i] - 'a' + offset) % 26 + 'a');
        }
        return new String(cs);
    }
}
