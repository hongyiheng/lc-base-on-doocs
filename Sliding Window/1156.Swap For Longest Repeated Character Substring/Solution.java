class Solution {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0, i = 0, n = text.length();
        while (i < n) {
            int j = i + 1;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            ans = Math.max(ans, Math.min(j - i + k - j, cnt[text.charAt(i) - 'a']));
            i = j;
        }
        return ans;
    }
}