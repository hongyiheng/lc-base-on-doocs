class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt = new int[26], t = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            t[c - 'a']++;
        }
        int ans = 100;
        for (int i = 0; i < 26; i++) {
            if (t[i] == 0) {
                continue;
            }
            ans = Math.min(ans, cnt[i] / t[i]);
        }
        return ans;
    }
}