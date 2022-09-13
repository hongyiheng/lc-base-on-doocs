class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (q.isEmpty() || q.peekLast()[1] > nums[i]) {
                q.addLast(new int[]{i, nums[i]});
            }
        }
        int ans = 0;
        for (int j = n - 1; j > -1; j--) {
            while (!q.isEmpty() && q.peekLast()[0] >= j) {
                q.pollLast();
            }
            while (!q.isEmpty() && q.peekLast()[1] <= nums[j]) {
                ans = Math.max(ans, j - q.pollLast()[0]);
            }
        }
        return ans;
    }
}