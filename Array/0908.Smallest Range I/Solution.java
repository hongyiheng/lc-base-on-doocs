class Solution {
    public int smallestRangeI(int[] A, int K) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for (int num : A) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        int diff = maxVal - minVal - 2 * K;
        return Math.max(diff, 0);
    }
}