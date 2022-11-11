class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        int l = 0, r = 0, mx = 0;
        while (r < n) {
            mx = Math.max(mx, ++cnt[s.charAt(r) - 'A']);
            if (r - l + 1 > mx + k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
