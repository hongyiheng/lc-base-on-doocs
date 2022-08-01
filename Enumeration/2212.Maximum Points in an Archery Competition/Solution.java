class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] ans = new int[12];
        int mx = 0;
        for (int i = 0; i < 1 << 12; i++) {
            int cur = 0, use = 0;
            int[] tmp = new int[12];
            for (int j = 0; j < 12; j++) {
                if ((i & (1 << j)) != 0) {
                    cur += j;
                    use += aliceArrows[j] + 1;
                    tmp[j] += aliceArrows[j] + 1;
                }
            }
            if (use > numArrows) {
                continue;
            }
            if (cur > mx) {
                mx = cur;
                tmp[0] += numArrows - use;
                ans = tmp.clone();
            }
        }
        return ans;
    }
}