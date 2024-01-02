class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int i = 1, n = word.length();
        int ans = 0;
        while (i < n) {
            int c = word.charAt(i - 1) - 'a';
            for (int j = c - 1; j <= c + 1; j++) {
                if (word.charAt(i) - 'a' == j) {
                    ans++;
                    i++;
                    break;
                }
            }
            i++;
        }
        return ans;
    }
}