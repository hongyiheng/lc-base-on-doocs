class Solution {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1010];
        for (int v : answers) {
            cnt[v]++;
        }
        int ans = 0;
        for (int i = 0; i < 1010; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            ans += (cnt[i] + i) / (i + 1) * (i + 1);
        }
        return ans;
    }
}