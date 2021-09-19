class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int ans = Integer.MIN_VALUE, max = values[0] + 0;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, values[i] - i + max);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}