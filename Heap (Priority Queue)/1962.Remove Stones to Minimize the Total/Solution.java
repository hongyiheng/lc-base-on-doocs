class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        for (int v : piles) {
            ans += v;
            q.offer(v);
        }
        for (int i = 0; i < k; i++) {
            int v = q.poll();
            int nv = (v + 1) / 2;
            ans -= (v - nv);
            q.offer(nv);
        }
        return ans;
    }
}