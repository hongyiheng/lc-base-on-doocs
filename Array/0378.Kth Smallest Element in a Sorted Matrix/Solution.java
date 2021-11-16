class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p.add(matrix[i][j]);
            }
        }
        Collections.sort(p);
        return p.get(k - 1);
    }
}