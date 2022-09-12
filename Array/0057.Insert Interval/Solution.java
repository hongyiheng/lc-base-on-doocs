class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>();
        int idx = 0, n = intervals.length;
        while (idx < n && intervals[idx][1] < newInterval[0]) {
            arr.add(intervals[idx]);
            idx++;
        }
        int left = newInterval[0], right = newInterval[1];
        while (idx < n && right >= intervals[idx][0]) {
            left = Math.min(left, intervals[idx][0]);
            right = Math.max(right, intervals[idx][1]);
            idx++;
        }
        arr.add(new int[]{left, right});
        while(idx < n) {
            arr.add(intervals[idx]);
            idx++;
        }
        int[][] ans = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            ans[i][0] = arr.get(i)[0];
            ans[i][1] = arr.get(i)[1];
        }
        return ans;
    }
}