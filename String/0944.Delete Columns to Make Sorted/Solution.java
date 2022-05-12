class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int ans = 0;
        for (int j = 0; j < n; j++) {
            char last = strs[0].charAt(j);
            for (int i = 1; i < m; i++) {
                char cur = strs[i].charAt(j);
                if (cur < last) {
                    ans++;
                    break;
                }
                last = cur;
            }
        }
        return ans;
    }
}