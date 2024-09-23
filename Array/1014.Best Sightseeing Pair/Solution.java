class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int mx = -1, ans = 0;
        for (int i = 0; i < values.length; i++) {
            if (mx != -1) {
                ans = Math.max(ans, values[mx] + values[i] + mx - i);
            }
            if (mx == -1 || values[i] > values[mx] + mx - i) {
                mx = i;
            }
        }
        return ans;
    }
}