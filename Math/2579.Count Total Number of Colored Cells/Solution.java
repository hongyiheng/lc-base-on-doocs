class Solution {
    public long coloredCells(int n) {
        long ans = 2 * n - 1, cur = 1;
        for (int i = 0; i < n - 1; i++) {
            ans += cur * 2;
            cur += 2;
        }
        return ans;
    }
}