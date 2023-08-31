class Solution {

    int[][] cnt;
    int n;

    public boolean check(int l, int r, int k) {
        for (int i = 0; i < 3; i++) {
            if (cnt[n][i] - (cnt[r][i] - cnt[l][i]) < k) {
                return false;
            }
        }
        return true;
    }

    public int takeCharacters(String s, int k) {
        n = s.length();
        cnt = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i].clone();
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (cnt[n][i] < k) {
                return -1;
            }
        }
        int ans = n + 1;
        int l = 0, r = 0;
        while (r < n + 1) {
            while (r < n + 1 && check(l, r, k)) {
                ans = Math.min(ans, n - (r - l));
                r++;
            }
            while (l < r && r < n + 1 && !check(l, r, k)) {
                l++;
            }
            r++;
        }
        return ans;
    }
}