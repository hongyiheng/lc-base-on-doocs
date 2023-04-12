class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        int ans = 0, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (players[i] <= trainers[j]) {
                ans++;
                j--;
            }
            i--;
        }
        return ans;
    }
}
