class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (check(s, word)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean check(String s, String w) {
        int n = s.length(), m = w.length();
        if (m > n) {
            return false;
        }
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while (r1 < n && r2 < m) {
            if (s.charAt(l1) != w.charAt(l2)) {
                return false;
            }
            char c = s.charAt(l1);
            while (r1 < n && s.charAt(r1) == c) {
                r1++;
            }
            while (r2 < m && w.charAt(r2) == c) {
                r2++;
            }
            int len1 = r1 - l1, len2 = r2 - l2;
            if (len1 < len2 || (len1 > len2 && len1 < 3)) {
                return false;
            }
            l1 = r1;
            l2 = r2;
        }
        return l1 == n && l2 == m;
    }
}
