class Solution {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) {
            return word;
        }
        String suffix = word.substring(0, i + 1);
        StringBuilder ans = new StringBuilder(suffix);
        ans.reverse();
        ans.append(word.substring(i + 1, word.length()));
        return ans.toString();
    }
}