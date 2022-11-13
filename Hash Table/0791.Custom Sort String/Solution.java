class Solution {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a'] > 0) {
                cnt[c - 'a']--;
                ans.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                ans.append((char)('a' + i));
                cnt[i]--;
            }
        }
        return ans.toString();
    }
}
