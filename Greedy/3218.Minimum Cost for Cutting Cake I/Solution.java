class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int ans = 0, i = 0, j = 0;
        while (i < m - 1 || j < n - 1) {
            if (i < m - 1 && j < n - 1) {
                if (horizontalCut[m - i - 2] < verticalCut[n - j - 2]) {
                    ans += verticalCut[n - j - 2] * (i + 1);
                    j++;
                } else {
                    ans += horizontalCut[m - i - 2] * (j + 1);
                    i++;
                }
            } else if (i < m - 1) {
                ans += horizontalCut[m - i - 2] * (j + 1);
                i++;
            } else {
                ans += verticalCut[n - j - 2] * (i + 1);
                j++;
            }
        }
        return ans;
    }
}