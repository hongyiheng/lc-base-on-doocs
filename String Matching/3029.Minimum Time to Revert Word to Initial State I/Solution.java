class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int ans = 0, n = word.length();
        for (int i = k; i < n; i += k) {
            ans++;
            String s = word.substring(i);
            if (s.equals(word.substring(0, s.length()))) {
                return ans;
            }
        }
        return ans + 1;
    }
}