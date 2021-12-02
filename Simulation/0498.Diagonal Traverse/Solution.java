class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] up = new int[]{-1, 1};
        int[] down = new int[]{1, -1};
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, index = 0;
        boolean flag = true;
        while (true) {
            if (i < 0 || i > m - 1 || j < 0 || j > n -1) {
                flag = !flag;
            }
            if (i > m - 1) {
                j += 2;
            }
            if (j > n - 1) {
                i += 2;
            }
            i = Math.max(0, i);
            j = Math.max(0, j);
            i = Math.min(m - 1, i);
            j = Math.min(n - 1, j);
            res[index++] = mat[i][j];
            if (i == m - 1 && j == n - 1) {
                break;
            }
            if (flag) {
                i += up[0];
                j += up[1];
            } else {
                i += down[0];
                j += down[1];
            }
        }
        return res;
    }
}