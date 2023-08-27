class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0, n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        while (i < n) {
            int l = intervals[i][0], r = intervals[i][1];
            while (i + 1 < n && intervals[i + 1][0] <= r) {
                r = Math.max(r, intervals[++i][1]);
            }
            ans.add(new int[]{l, r});
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}