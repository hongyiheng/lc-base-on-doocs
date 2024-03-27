class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int x = 0, maxR = -1;
        for (int[] e : ranges) {
            int l = e[0], r = e[1];
            if (l > maxR) {
                x++;
            }
            maxR = Math.max(maxR, r);
        }
        int ans = 1;
        for (int i = 0; i < x; i++) {
            ans = (int)((long)ans * 2 % (int)(1e9 + 7));
        }
        return ans;
    }
}