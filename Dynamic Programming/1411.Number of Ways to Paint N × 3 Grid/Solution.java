class Solution {
    public int numOfWays(int n) {
        int M = (int)1e9 + 7;
        // 三色 f1, 双色 f2
        long f1 = 6L, f2 = 6L;
        for (int i = 1; i < n; i++) {
            // 每个三色的下一行, 有 2 个三色, 2 个双色
            // 每个双色的下一行, 有 2 个三色, 3 个双色
            long nf1 = f1 * 2 + f2 * 2;
            long nf2 = f1 * 2 + f2 * 3;
            f1 = nf1 % M;
            f2 = nf2 % M;
        }
        return (int)((f1 + f2) % M);
    }
}