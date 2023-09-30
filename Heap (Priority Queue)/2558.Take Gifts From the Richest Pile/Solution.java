class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int v : gifts) {
            q.offer(v);
        }
        for (int i = 0; i < k; i++) {
            int v = q.poll();
            q.offer((int) Math.sqrt(v));
        }
        return q.stream().mapToLong(e -> e).sum();
    }
}