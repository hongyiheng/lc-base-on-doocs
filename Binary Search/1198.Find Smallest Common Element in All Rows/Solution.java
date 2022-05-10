class Solution {
    int m, n;
    int[][] mat;

    public int smallestCommonElement(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        this.mat = mat;
        for (int v : mat[0]) {
            if (existNum(v)) {
                return v;
            }
        }
        return -1;
    }

    public boolean existNum(int target) {
        for (int i = 1; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (mat[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (mat[i][left] != target) {
                return false;
            }
        }
        return true;
    }
}