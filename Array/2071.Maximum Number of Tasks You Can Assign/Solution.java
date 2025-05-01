class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] cnt = new int[26];
        int ans = 0, l = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r) - 'a']++;
            while (Arrays.stream(cnt).max().getAsInt() >= k) {
                ans += n - r;
                cnt[s.charAt(l++) - 'a']--;
            }
        }
        return ans;
    }
}