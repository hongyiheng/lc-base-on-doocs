class Solution {
    public int minSwaps(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] q = new int[n];
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                cnt++;
            }
            q[i] = cnt;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (q[i] >= n - i - 1) {
                continue;
            }
            int j = i + 1;
            while (j < n) {
                if (q[j] >= n - i - 1) {
                    break;
                }
                j++;
            }
            if (j == n) {
                return -1;
            }
            for (int k = j; k > i; k--) {
                int tmp = q[k];
                q[k] = q[k - 1];
                q[k - 1] = tmp;
                ans++;
            }
        }
        return ans;
    }
}