class Solution {
    public int countVowelStrings(int n) {
        int[][] f = new int[n][5];
        for (int i = 0; i < 5; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < j + 1; k++) {
                    f[i][j] += f[i - 1][k];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += f[n - 1][i];
        }
        return ans;
    }
}