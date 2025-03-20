class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] f = new int[n];
        Arrays.fill(f, -1);
        f[p] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{0, p});
        Set<Integer> banSet = new HashSet<>();
        for (int b : banned) {
            banSet.add(b);
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int w = cur[0], pos = cur[1];
            for (int np = Math.max(0, pos - k + 1); np < Math.min(n, pos + k); np++) {
                if ((f[np] != -1 && f[np] <= f[pos] + 1) || banSet.contains(np)) {
                    continue;
                }
                if ((k - Math.abs(np - pos) - 1) % 2 != 0) {
                    continue;
                }
                int t = (k - Math.abs(np - pos) - 1) / 2;
                if (0 <= Math.min(np, pos) - t && Math.max(np, pos) + t < n) {
                    f[np] = f[pos] + 1;
                    q.offer(new int[]{f[np], np});
                }
            }
        }
        return f;
    }
}