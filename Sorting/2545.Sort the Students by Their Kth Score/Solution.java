class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;
        int[][] col = new int[m][2];
        for (int i = 0; i < m; i++) {
            col[i] = new int[]{score[i][k], i};
        }
        Arrays.sort(col, (a, b) -> b[0] - a[0]);
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i] = score[col[i][1]];
        }
        return ans;
    }
}