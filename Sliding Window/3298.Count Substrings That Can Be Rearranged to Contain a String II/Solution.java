class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] t = new int[26], cnt = new int[26];
        for (char c : word2.toCharArray()) {
            t[c - 'a']++;
        }
        int n = word1.length();
        int l = 0, r = 0;
        long ans = 0;
        while (r < n) {
            int v = word1.charAt(r) - 'a';
            cnt[v]++;
            while (cnt[v] >= t[v] && check(cnt, t)) {
                ans += n - r;
                cnt[word1.charAt(l++) - 'a']--;
            }
            r++;
        }
        return ans;
    }

    public boolean check(int[] cnt, int[] t) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] < t[i]) {
                return false;
            }
        }
        return true;
    }
}
