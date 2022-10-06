class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                ans[q.pollLast()[0]] = nums[i];
            }
            q.addLast(new int[]{i, nums[i]});
        }
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                ans[q.pollLast()[0]] = nums[i];
            }
        }
        return ans;
    }
}
