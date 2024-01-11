class Solution {
    public int addMinimum(String word) {
        int t = 0, ans = 0;
        int i = 0, n = word.length();
        while (i < n) {
            int v = word.charAt(i) - 'a';
            if (v != t) {
                ans++;
            } else {
                i++;
            }
            t = (t + 1) % 3;
        }
        return ans + (3 - t) % 3;
    }
}