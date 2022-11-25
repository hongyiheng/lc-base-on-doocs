class Solution {
    public int maxEvents(int[][] events) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = 0;
        for (int[] v : events) {
            mp.computeIfAbsent(v[0], k -> new ArrayList<>()).add(v[1]);
            n = Math.max(n, v[1]);
        }
        int ans = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(n, (a, b) -> a[0] - b[0]);
        for (int i = 1; i <= n; i++) {
            if (mp.containsKey(i)) {
                for (int v : mp.get(i)) {
                    q.offer(new int[]{v, i});
                }
            }
            while (!q.isEmpty() && q.peek()[0] < i) {
                q.poll();
            }
            if (!q.isEmpty() && q.peek()[1] <= i) {
                ans++;
                q.poll();
            }
        }
        return ans;

    }
}
