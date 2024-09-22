class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] q = new int[n + 1][2];
        for (int[] t : trust) {
            q[t[0]][0]++;
            q[t[1]][1]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (q[i][0] == 0 && q[i][1] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}