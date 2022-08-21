class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length(), idx = 0;
        String[] ans = new String[n + 1];
        for (int i = 1; i < n + 2; i++) {
            ans[i - 1] = String.valueOf(i);
        }
        char[] cs = pattern.toCharArray();
        while (idx < n) {
            if (cs[idx] == 'I') {
                idx++;
                continue;
            }
            int l = idx;
            while (idx < n && cs[idx] == 'D') {
                idx++;
            }
            int r = idx;
            while (l < r) {
                String tmp = ans[l];
                ans[l] = ans[r];
                ans[r] = tmp;
                l++;
                r--;
            }
        }
        return String.join("", ans);
    }
}