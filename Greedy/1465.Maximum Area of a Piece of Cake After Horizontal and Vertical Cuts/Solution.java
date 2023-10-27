class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n = horizontalCuts.length, m = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mh = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        int mw = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 0; i < n - 1; i++) {
            mh = Math.max(mh, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < m - 1; i++) {
            mw = Math.max(mw, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int) (1L * mh * mw % ((int)1e9 + 7));
    }
}