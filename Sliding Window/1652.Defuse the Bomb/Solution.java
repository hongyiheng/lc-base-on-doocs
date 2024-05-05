class Solution {

    public int getS(int[] code, int k) {
        int ans = 0, n = code.length;
        if (k > 0) {
            for (int i = 1; i < k + 1; i++) {
                ans += code[i];
            }
        } else {
            for (int i = n - 1; i >= n + k; i--) {
                ans += code[i];
            }
        }
        return ans;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int s = getS(code, k);
        for (int i = 0; i < n; i++) {
            ans[i] = s;
            if (k > 0) {
                s += code[(i + k + 1) % n];
                s -= code[(i + 1) % n];
            } else {
                s += code[i];
                s -= code[(n + k + i + n) % n];
            }
        }
        return ans;
    }
}