class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> allx = new ArrayList<>();
        List<Integer> ally = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    allx.add(i);
                    ally.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (allx.contains(i) || ally.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}