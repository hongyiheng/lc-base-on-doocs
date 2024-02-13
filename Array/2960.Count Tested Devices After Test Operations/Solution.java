class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0, cur = 1;
        for (int v : batteryPercentages) {
            if (v >= cur) {
                ans++;
                cur++;
            }
        }
        return ans;
    }
}