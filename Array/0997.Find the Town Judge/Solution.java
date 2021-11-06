class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        boolean[] notJudge = new boolean[n + 1];
        for (int [] item : trust) {
            notJudge[item[0]] = true;
            ++count[item[1]];
        }

        for (int i = 1; i < n + 1; i++) {
            if (count[i] == n - 1 && !notJudge[i]) {
                return i;
            }
        }
        return -1;
    }
}