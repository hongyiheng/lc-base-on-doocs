class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int n = s.length(), ans = 0, l = 0, r = 0;
        while (r < n) {
            cnt[s.charAt(r) - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += n - r;
                cnt[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return ans;
    }
}