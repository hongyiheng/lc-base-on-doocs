class Solution {
    public int appendCharacters(String s, String t) {
        int m = t.length();
        int ans = m, idx = 0;
        for (int i = 0; i < m; i++) {
            int j = s.indexOf(t.charAt(i), idx);
            if (j == -1) {
                break;
            } else {
                ans--;
                idx = j + 1;
            }
        }
        return ans;
    }
}
