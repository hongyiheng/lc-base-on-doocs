class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix[0].length;
        int[][] rotate = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rotate[j][len - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}