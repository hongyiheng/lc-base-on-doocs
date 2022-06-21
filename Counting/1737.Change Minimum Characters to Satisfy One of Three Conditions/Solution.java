class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length(), n = b.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < m; i++) {
            cnt1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            cnt2[b.charAt(i) - 'a']++;
        }
        int ans = m - cnt1[0] + n - cnt2[0];
        for (int i = 1; i < 26; i++) {
            int first = 0, second = 0, third = 0;
            for (int j = i; j < 26; j++) {
                first += cnt1[j];
                second += cnt2[j];
            }
            for (int j = 0; j < i; j++) {
                first += cnt2[j];
                second += cnt1[j];
            }
            ans = Math.min(ans, Math.min(first, second));
            third = m - cnt1[i] + n - cnt2[i];
            ans = Math.min(ans, third);
        }
        return ans;
    }
}