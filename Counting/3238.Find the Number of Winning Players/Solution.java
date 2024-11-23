class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] cnt = new int[n][11];
        int ans = 0;
        for (int[] p : pick) {
            int i = p[0], v = p[1];
            if ((ans >> i & 1) == 1) {
                continue;
            }
            if (++cnt[i][v] > i) {
                ans |= 1 << i;
            }
        }
        return Integer.bitCount(ans);
    }
}