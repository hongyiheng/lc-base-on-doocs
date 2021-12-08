class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) {
                return 1;
            }
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        Deque<Integer> lefts = new ArrayDeque<>();
        for (int r = 0; r < pre.length; r++) {
            while (!lefts.isEmpty() && pre[r] <= pre[lefts.getLast()]) {
                lefts.removeLast();
            }
            while (!lefts.isEmpty() && pre[r] - pre[lefts.peek()] >= k) {
                ans = Math.min(ans, r - lefts.poll());
            }
            lefts.add(r);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}