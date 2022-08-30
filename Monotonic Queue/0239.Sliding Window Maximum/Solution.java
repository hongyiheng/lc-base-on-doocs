class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (i >= k - 1) {
                while (!q.isEmpty() && q.peekFirst() <= i - k) {
                    q.pollFirst();
                }
                ans[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}