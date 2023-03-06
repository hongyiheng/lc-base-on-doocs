class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[][] cnt = new int[n + 1][2];
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                b++;
            }
            cnt[i + 1][1] = b;
        }
        for (int i = n; i > 0; i--) {
            cnt[i - 1][0] = a;
            if (s.charAt(i - 1) == 'a') {
                a++;
            }
        }
        int ans = n;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.min(ans, cnt[i][0] + cnt[i][1]);
        }
        return ans;
    }
}