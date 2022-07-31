class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int m = matches.length;
        int[] loseTime = new int[100010];
        Arrays.fill(loseTime, -1);
        for (int i = 0; i < m; i++) {
            int w = matches[i][0], l = matches[i][1];
            if (loseTime[w] == -1) {
                loseTime[w] = 0;
            }
            loseTime[l] = loseTime[l] == -1 ? 1 : loseTime[l] + 1;
        }
        List<Integer> winner = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();
        for (int i = 0; i < 100010; i++) {
            if (loseTime[i] == 0) {
                winner.add(i);
            } else if (loseTime[i] == 1) {
                loseOne.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(winner);
        ans.add(loseOne);
        return ans;
    }
}