class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int[] row = matrix[left];
        left = 0; right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return row[left] == target;
    }
}