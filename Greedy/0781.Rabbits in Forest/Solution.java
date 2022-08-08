class Solution {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1010];
        for (int v : answers) {
            cnt[v]++;
        }
        int ans = 0;
        for (int i = 0; i < 1010; i++) {
            ans += cnt[i];
            if (cnt[i] % (i + 1) != 0) {
                ans = ans + (i + 1) - cnt[i] % (i + 1);
            }
        }
        return ans;
    }
}