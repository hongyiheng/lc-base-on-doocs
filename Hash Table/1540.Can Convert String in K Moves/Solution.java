class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int[] cnt = new int[26];
        int n = s.length(), m = t.length();
        if (n != m) {
            return false;
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            diff += 26 * cnt[diff]++;
            mx = Math.max(mx, diff);
        }
        return mx <= k;
    }
}