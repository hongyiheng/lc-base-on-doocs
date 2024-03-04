class Solution {
    public String lastNonEmptyString(String s) {
        int[] cnt = new int[26];
        int mx = 0;
        for (char c : s.toCharArray()) {
            mx = Math.max(mx, ++cnt[c - 'a']);
        }
        Arrays.fill(cnt, 0);
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (++cnt[c - 'a'] == mx) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}