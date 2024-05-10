class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0, cnt = 0;
        for (int v : batteryPercentages) {
            if (v - cnt > 0) {
                cnt++;
                ans++;
            }
        }
        return ans;
    }
}