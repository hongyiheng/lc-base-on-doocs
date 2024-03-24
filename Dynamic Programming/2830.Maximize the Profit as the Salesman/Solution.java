class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] f = new int[n];
        int m = offers.size();
        offers.sort((a, b) -> a.get(1) - b.get(1));
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                f[i] = f[i - 1];
            }
            while (j < m && offers.get(j).get(1) <= i) {
                int s = offers.get(j).get(0), e = offers.get(j).get(1), w = offers.get(j).get(2);
                f[e] = Math.max(f[e], (s - 1 < 0 ? 0 : f[s - 1]) + w);
                j++;
            }
        }
        return f[n - 1];
    }
}