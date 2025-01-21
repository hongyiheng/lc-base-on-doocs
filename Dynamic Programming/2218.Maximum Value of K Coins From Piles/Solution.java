class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                f[i + 1][j] = f[i][j];
                int s = 0;
                for (int x = 0; x < Math.min(j, piles.get(i).size()); x++) {
                    s += piles.get(i).get(x);
                    f[i + 1][j] = Math.max(f[i + 1][j], f[i][j - x - 1] + s);
                }
            }
        }
        return f[n][k];
    }
}