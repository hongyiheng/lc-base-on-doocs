class Solution {
    public String truncateSentence(String s, int k) {
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length && k > 0; i++) {
            if (chars[i] == ' ') {
                k--;
            } else {
                index = i;
            }
        }
        return s.substring(0, index + 1);
    }
}