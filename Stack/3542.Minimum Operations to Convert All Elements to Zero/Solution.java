class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> q = new ArrayDeque();
        for (int v : nums) {
            while (!q.isEmpty() && q.peekLast() > v) {
                q.pollLast();
                ans++;
            }
            if (q.isEmpty() || q.peekLast() != v) {
                q.addLast(v);
            }
        }
        for (int v : q) {
            if (v != 0) {
                ans++;
            }
        }
        return ans;
    }
}