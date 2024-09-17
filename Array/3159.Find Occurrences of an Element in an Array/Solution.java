class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length, m = nums.length;
        int[][] qs = new int[n][2];
        for (int i = 0; i < n; i++) {
            qs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int s = 0, j = 0;
        for (int i = 0; i < m; i++) {
            if (x == nums[i]) {
                s++;
            }
            while (j < n && s >= qs[j][0]) {
                ans[qs[j++][1]] = i;
            }
        }
        return ans;
    }
}