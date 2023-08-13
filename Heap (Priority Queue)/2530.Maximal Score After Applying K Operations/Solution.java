class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int v : nums) {
            q.add(v);
        }
        long ans = 0;
        while (k-- > 0) {
            int v = q.poll();
            ans += v;
            v = v / 3 + (v % 3 == 0 ? 0 : 1);
            q.add(v);
        }
        return ans;
    }
}