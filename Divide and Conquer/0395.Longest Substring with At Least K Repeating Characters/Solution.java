class Solution {
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] < k) {
                char c = (char)('a' + i);
                int ans = 0;
                for (String ss : s.split(String.valueOf(c))) {
                    ans = Math.max(ans, longestSubstring(ss, k));
                }
                return ans;
            }
        }
        return s.length();
    }
}