class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i * 2 + 1 < n; i++) {
            ans += n - (i * 2 + 1);
        }
        return ans;
    }
}