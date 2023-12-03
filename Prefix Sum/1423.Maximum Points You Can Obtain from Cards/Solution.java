class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int w = n - k;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + cardPoints[i - 1];
        }
        int m = Integer.MAX_VALUE;
        for (int l = 0; l + w <= n; l++) {
            int right = l + w;
            m = Math.min(m, pre[right] - pre[l]);
        }
        return pre[n] - m;
    }
}