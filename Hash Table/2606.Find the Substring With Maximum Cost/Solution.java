class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] g = new int[26];
        for (int i = 0; i < 26; i++) {
            g[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            g[chars.charAt(i) - 'a'] = vals[i];
        }
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            cnt += g[c- 'a'];
            cnt = Math.max(cnt, 0);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}