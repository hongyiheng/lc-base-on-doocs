class Solution {
    long[] h;
    long[] p;
    int P = 131;
    public String longestDupSubstring(String s) {
        int n = s.length();
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }
        int left = 0, right = n;
        String ans = "";
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            String t = check(s, mid);
            ans = t.length() > ans.length() ? t : ans;
            if ("".equals(t)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return ans;
    }

    public String check(String s, int len) {
        Set<Long> seen = new HashSet<>();
        for (int i = 1; i <= s.length() - len + 1; i++) {
            int j = i + len - 1;
            long hash = h[j] - h[i - 1] * p[j - i + 1];
            if (seen.contains(hash)) {
                return s.substring(i - 1, j);
            }
            seen.add(hash);
        }
        return "";
    }
}