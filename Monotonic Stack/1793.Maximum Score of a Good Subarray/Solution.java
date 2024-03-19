class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (!q.isEmpty() && nums[q.peekLast()] >= v) {
                q.pollLast();
            }
            if (!q.isEmpty()) {
                left[i] = q.peekLast();
            }
            q.addLast(i);
        }
        int[] right = new int[n];
        Arrays.fill(right, n);
        q.clear();
        for (int i = n - 1; i > -1; i--) {
            int v = nums[i];
            while (!q.isEmpty() && nums[q.peekLast()] >= v) {
                q.pollLast();
            }
            if (!q.isEmpty()) {
                right[i] = q.peekLast();
            }
            q.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int h = nums[i], l = left[i], r = right[i];
            if (l < k && k < r) {
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }
}