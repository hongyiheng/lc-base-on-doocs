class Solution {
    public int maxProduct(int n) {
        int mx = 0, ans = 0;
        while (n > 0) {
            int v = n % 10;
            ans = Math.max(ans, mx * v);
            mx = Math.max(mx, v);
            n /= 10;
        }
        return ans;
    }
}