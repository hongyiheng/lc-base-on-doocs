class Solution {

    public int dfs(int s, int d, int n) {
        if (s + d == n) {
            return 1;
        }
        if (s + d > n) {
            return 0x3f3f3f3f;
        }
        return Math.min(dfs(s + d, d, n) + 1, dfs(s + s, s, n) + 2);
    }

    public int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        return dfs(1, 1, n) + 1;
    }
}