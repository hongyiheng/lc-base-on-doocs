class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int l = 0, r = 0, n = s2.length();
        while (r < n) {
            char c = s2.charAt(r);
            while (l < r && cnt[c - 'a'] == 0) {
                cnt[s2.charAt(l) - 'a']++;
                l++;
            }
            if (cnt[c - 'a'] == 0) {
                l++;
            } else {
                cnt[c - 'a']--;
                if (r - l + 1 == s1.length()) {
                    return true;
                }
            }
            r++;
        }
        return false;
    }
}
