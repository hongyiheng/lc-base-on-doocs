class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length(), idx = 0;
        StringBuilder ans = new StringBuilder();
        while (idx < n || idx < m) {
            if (idx < n) {
                ans.append(word1.charAt(idx));
            }
            if (idx < m) {
                ans.append(word2.charAt(idx));
            }
            idx++;
        }
        return ans.toString();
    }
}
