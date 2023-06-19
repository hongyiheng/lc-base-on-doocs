class Solution {

    public boolean dfs(String s, int t, int i, int cur) {
        if (i == s.length()) {
            return cur == t;
        }
        for (int j = i + 1; j < s.length() + 1; j++) {
            if (dfs(s, t, j, cur + Integer.parseInt(s.substring(i, j)))) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(String.valueOf(i * i), i, 0, 0)) {
                ans += i * i;
            }
        }
        return ans;
    }

}
