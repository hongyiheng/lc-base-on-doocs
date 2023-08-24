class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] cp = new int[n][2];
        for (int i = 0; i < n; i++) {
            cp[i][0] = capital[i];
            cp[i][1] = profits[i];
        }
        Arrays.sort(cp, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while (k-- > 0) {
            while (i < n && cp[i][0] <= w) {
                q.add(cp[i][1]);
                i++;
            }
            if (q.isEmpty()) {
                break;
            }
            w += q.poll();
        }
        return w;
    }
}