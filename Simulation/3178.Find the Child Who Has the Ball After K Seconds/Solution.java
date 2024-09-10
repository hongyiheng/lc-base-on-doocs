class Solution {
    public int numberOfChild(int n, int k) {
        boolean d = true;
        int ans = 0;
        while (k > 0) {
            if (ans == 0) {
                d = true;
            } else if (ans == n - 1) {
                d = false;
            }
            int v = Math.min(k, n - 1);
            ans = d ? ans + v : ans - v;
            k -= v;
        }
        return ans;
    }
}