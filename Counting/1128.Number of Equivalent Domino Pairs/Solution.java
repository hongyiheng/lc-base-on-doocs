class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] cnt = new int[10][10];
        int ans = 0;
        for (int[] v : dominoes) {
            int a = v[0], b = v[1];
            ans += cnt[a][b]++;
            cnt[b][a] = cnt[a][b];
        }
        return ans;
    }
}