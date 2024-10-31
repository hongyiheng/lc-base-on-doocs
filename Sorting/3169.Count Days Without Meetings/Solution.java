class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int ans = 0, mx = 0;
        for (int[] e : meetings) {
            int u = e[0], v = e[1];
            if (u > mx + 1) {
                ans += u - mx - 1;
            }
            mx = Math.max(mx, v);
        }
        return mx >= days ? ans : ans + days - mx;
    }
}