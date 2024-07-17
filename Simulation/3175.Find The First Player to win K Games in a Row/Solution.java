class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int ans = 0, cur = skills[0], cnt = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] > cur) {
                cur = skills[i];
                cnt = 0;
                ans = i;
            }
            if (++cnt >= k) {
                return ans;
            }
        }
        return ans;
    }
}