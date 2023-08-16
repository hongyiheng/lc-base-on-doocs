class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] s = new boolean[n + 1];
        int pos = 1, cnt = 0;
        while (!s[pos]) {
            s[pos] = true;
            cnt++;
            pos = (pos + cnt * k - 1) % n + 1;
        }
        int[] ans = new int[n - cnt];
        for (int i = 1, j = 0; i <= n; i++) {
            if (!s[i]) {
                ans[j++] = i;
            }
        }
        return ans;
    }
}