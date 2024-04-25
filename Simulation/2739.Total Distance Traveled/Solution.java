class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0, cnt = 0;
        while (mainTank > 0) {
            ans += mainTank * 10;
            cnt += mainTank;
            int extra = Math.min(cnt / 5, additionalTank);
            additionalTank -= extra;
            cnt %= 5;
            mainTank = extra;
        }
        return ans;
    }
}