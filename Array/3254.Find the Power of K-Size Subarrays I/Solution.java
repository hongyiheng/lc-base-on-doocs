class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && nums[q.peekLast()] + 1 != nums[i]) {
                q.clear();
            }
            q.add(i);
            if (i >= k - 1) {
                if (q.size() == k) {
                    ans[i - k + 1] = nums[i];
                    q.pollFirst();
                } else {
                    ans[i - k + 1] = -1;
                }
            }
        }
        return ans;
    }
}