class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            while (!q.isEmpty() && q.peekLast() > v && n - i > k - q.size()) {
                q.pollLast();
            }
            if (q.size() < k) {
                q.addLast(v);
            }
        }
        return q.stream().mapToInt(e -> e).toArray();
    }
}