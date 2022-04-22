class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<int[], Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = mp.get(intervals[i]);
            int target = intervals[i][1];
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (intervals[mid][0] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (intervals[left][0] >= target) {
                ans[idx] = mp.get(intervals[left]);
            } else {
                ans[idx] = -1;
            }
        }
        return ans;
    }
}