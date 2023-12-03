class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (n == k) {
            return (int)Arrays.stream(cardPoints).sum();
        }
        int total = 0, s = 0, l = 0, r = 0;
        int mi = 0x3f3f3f3f;
        while (r < n) {
            s += cardPoints[r];
            total += cardPoints[r];
            if (r - l + 1 == n - k) {
                mi = Math.min(mi, s);
                s -= cardPoints[l++];
            }
            r += 1;
        }
        return total - mi;
    }
}