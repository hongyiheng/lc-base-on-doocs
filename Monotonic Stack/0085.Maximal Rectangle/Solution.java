class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] g = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    g[i][j] = i > 0 ? g[i - 1][j] + 1 : 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxArea(g[i]));
        }
        return ans;
    }

    public int maxArea(int[] hs) {
        int ans = 0;
        hs[hs.length - 1] = -1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < hs.length; i++) {
            while (!q.isEmpty() && hs[q.peekLast()] > hs[i]) {
                int h = hs[q.pollLast()];
                int l = q.isEmpty() ? -1 : q.peekLast();
                ans = Math.max(ans, (i - 1 - l) * h);
            }
            q.addLast(i);
        }
        return ans;
    }
}
