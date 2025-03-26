class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int i = 1; i < k / 2 + 1; i++) {
            ans += i;
            if (--n == 0) {
                return ans;
            }
        }
        while (n-- > 0) {
            ans += k++;
        }
        return ans;
    }
}