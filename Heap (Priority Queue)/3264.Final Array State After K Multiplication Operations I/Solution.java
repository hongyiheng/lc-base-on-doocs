class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            q.add(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] e = q.poll();
            q.add(new int[]{e[0] * multiplier, e[1]});
        }
        int[] ans = new int[n];
        for (int[] e : q) {
            ans[e[1]] = e[0];
        }
        return ans;
    }
}