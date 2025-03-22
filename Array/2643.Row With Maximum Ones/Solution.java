class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[]{0, 0};
        for (int i = 0; i < mat.length; i++) {
            int v = 0;
            for (int j = 0; j < mat[0].length; j++) {
                v += mat[i][j];
            }
            if (v > ans[1]) {
                ans = new int[]{i, v};
            }
        }
        return ans;
    }
}