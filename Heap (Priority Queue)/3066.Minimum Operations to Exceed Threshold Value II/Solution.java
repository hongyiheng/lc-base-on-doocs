class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue();
        for (int v : nums) {
            q.add((long)v);
        }
        int ans = 0;
        while (q.size() >= 2 && q.peek() < k) {
            long a = q.poll(), b = q.poll();
            q.add(1L * a * 2 + b);
            ans++;
        }
        return ans;
    }
}