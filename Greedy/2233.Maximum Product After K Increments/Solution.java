class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int v : nums) {
            q.offer(v);
        }
        while (k-- > 0) {
            int v = q.poll();
            q.offer(v + 1);
        }
        long ans = 1, mod = (long)1e9 + 7;
        for (int v : q) {
            ans = ans * v % mod;
        }
        return (int)ans;
    }
}