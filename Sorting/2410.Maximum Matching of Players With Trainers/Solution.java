class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = trainers.length;
        int i = 0, ans = 0;
        for (int v : players) {
            while (i < n && v > trainers[i]) {
                i++;
            }
            if (i >= n) {
                break;
            }
            ans++;
            i++;
        }
        return ans;
    }
}