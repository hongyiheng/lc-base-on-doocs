class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && i - q.peek()[1] > k) {
                q.poll();
            }
            int last = q.isEmpty() ? 0 : q.peek()[0];
            if (i == n - 1) {
                return last + nums[i];
            }
            q.add(new int[]{last + nums[i], i});
        }
        return -1;
    }
}