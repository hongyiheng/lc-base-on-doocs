class Solution {
    public int minimumMoves(String s) {
        int i = 0, ans = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == 'X') {
                i += 3;
                ans++;
            } else {
                i++;
            }
        }
        return ans;
    }
}