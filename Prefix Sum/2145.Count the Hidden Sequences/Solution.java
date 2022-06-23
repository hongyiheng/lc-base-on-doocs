class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        int lastHidden = lower, minVal = lower, maxVal = lower;
        for (int i = 1; i < n + 1; i++) {
            lastHidden = lastHidden + differences[i - 1];
            minVal = Math.min(minVal, lastHidden);
            maxVal = Math.max(maxVal, lastHidden);
        }
        int ans = 0;
        for (int i = lower; i <= upper; i++) {
            if (lower <= minVal && maxVal <= upper) {
                ans++;
            }
            minVal++;
            maxVal++;
        }
        return ans;
    }
}