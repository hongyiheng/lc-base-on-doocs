class Solution {
    public int minimumPossibleSum(int n, int target) {
        int M = (int)1e9 + 7;
        int cnt = Math.min(n, target / 2);
        long ans = (long)(1 + cnt) * cnt / 2;
        if (cnt < n) {
            ans += ((long)target + target + n - cnt - 1) * (n - cnt) / 2 % M;
        }
        return (int)(ans % M);
    }
}