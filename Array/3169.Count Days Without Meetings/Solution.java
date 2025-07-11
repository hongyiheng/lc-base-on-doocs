class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int s = 0, i = 0, n = meetings.length;
        while (i < n) {
            int l = meetings[i][0], r = meetings[i][1];
            while (i + 1 < n && meetings[i + 1][0] <= r) {
                r = Math.max(r, meetings[i + 1][1]);
                i++;
            }
            s += r - l + 1;
            i++;
        }
        return days - s;
    }
}