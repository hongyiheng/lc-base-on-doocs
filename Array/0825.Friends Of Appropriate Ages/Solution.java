class Solution {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int v : ages) {
            cnt[v]++;
        }
        int ans = 0;
        for (int i = 0; i < 121; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 0; j < 121; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                if (j <= 0.5 * i + 7 || j > i) {
                    continue;
                }
                ans += cnt[i] * (cnt[j] - (i == j ? 1 : 0));
            }
        }
        return ans;
    }
}