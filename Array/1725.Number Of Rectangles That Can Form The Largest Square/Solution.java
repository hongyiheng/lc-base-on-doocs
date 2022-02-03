class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        for (int[] r : rectangles) {
            maxLen = Math.max(maxLen, Math.min(r[0], r[1]));
        }
        int ans = 0;
        for (int[] r : rectangles) {
            if (Math.min(r[0], r[1]) == maxLen) {
                ans++;
            }
        }
        return ans;
    }
}