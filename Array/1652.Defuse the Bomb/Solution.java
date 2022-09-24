class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + code[i];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                if (i + k < n) {
                    ans[i] = pre[i + k + 1] - pre[i + 1];
                } else {
                    ans[i] = pre[n] - pre[i + 1] + pre[(i + k + 1) % n];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i + k >= 0) {
                    ans[i] = pre[i] - pre[i + k];
                } else {
                    ans[i] = pre[i] + pre[n] - pre[(i + k + n) % n];
                }
            }
        }
        return ans;
    }
}
