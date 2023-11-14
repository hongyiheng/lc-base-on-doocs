class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (s.charAt(i) == '1') {
                suf[i] = Math.min(suf[i] + 2, n - i);
            }
        }
        int pre = 0, ans = suf[0];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pre = Math.min(pre + 2, i + 1);
            }
            ans = Math.min(ans, pre + suf[i + 1]);
        }
        return ans;
    }
}