class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int i = 1; i < k / 2 + 1; i++) {
            if (n == 0) {
                break;
            }
            ans += i;
            n--;
        }
        while (n > 0) {
            ans += k++;
            n--;
        }
        return ans;
    }
}