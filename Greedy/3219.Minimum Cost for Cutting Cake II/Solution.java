class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0, j = 0;
        while (i < m - 1 || j < n - 1) {
            if (i < m - 1 && j < n - 1) {
                if (horizontalCut[m - i - 2] < verticalCut[n - j - 2]) {
                    ans += (long)verticalCut[n - j - 2] * (i + 1);
                    j++;
                } else {
                    ans += (long)horizontalCut[m - i - 2] * (j + 1);
                    i++;
                }
            } else if (i < m - 1) {
                ans += (long)horizontalCut[m - i - 2] * (j + 1);
                i++;
            } else {
                ans += (long)verticalCut[n - j - 2] * (i + 1);
                j++;
            }
        }
        return ans;
    }
}