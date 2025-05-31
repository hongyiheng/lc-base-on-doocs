class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Set<Integer> vis = new HashSet<>(Collections.singletonList(1));
        Deque<Integer> q = new ArrayDeque();
        q.offer(1);
        int ans = 0;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                int x = q.poll();
                if (x == n * n) {
                    return ans;
                }
                for (int nx = x + 1; nx < Math.min(x + 6, n * n) + 1; nx++) {
                    int i = (nx - 1) / n, j = (nx - 1) % n;
                    if (i % 2 == 1) {
                        j = n - 1 - j;
                    }
                    i = n - 1 - i;            
                    int v = board[i][j] == -1 ? nx : board[i][j];
                    if (!vis.contains(v)) {
                        vis.add(v);
                        q.offer(v);
                    }
                }
            }
            ans++;
        }
        return -1;   
    }
}