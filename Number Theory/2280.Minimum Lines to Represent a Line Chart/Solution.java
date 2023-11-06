class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n <= 1) {
            return 0;
        }
        int ans = 1;
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        for (int i = 2; i < n; i++) {
            int x1 = stockPrices[i - 2][0], y1 = stockPrices[i - 2][1];
            int x2 = stockPrices[i - 1][0], y2 = stockPrices[i - 1][1];
            int x3 = stockPrices[i][0], y3 = stockPrices[i][1];
            if ((long)(x2 - x1) * (y3 - y2) != (long)(x3 - x2) * (y2 - y1)) {
                ans++;
            }
        }
        return ans;
    }
}