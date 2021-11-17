class Solution {
    int row;
    int col;
    public int kthSmallest(int[][] matrix, int k) {
        row = matrix.length;
        col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = getLessNumCount(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getLessNumCount(int[][] matrix, int mid) {
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}