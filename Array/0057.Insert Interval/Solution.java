class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int l = newInterval[0], r = newInterval[1];
        while (i < n && intervals[i][0] <= r && intervals[i][1] >= l) {
            l = Math.min(l, intervals[i][0]);
            r = Math.max(r, intervals[i][1]);
            i++;
        }
        ans.add(new int[]{l, r});
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}