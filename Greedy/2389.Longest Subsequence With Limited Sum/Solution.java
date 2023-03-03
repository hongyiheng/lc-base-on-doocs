class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        int idx = 0, cur = 0, k = 0;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int v = q[i][0], j = q[i][1];
            while (idx < n && cur + nums[idx] <= v) {
                cur += nums[idx++];
                k++;
            }
            ans[j] = k;
        }
        return ans;
    }
}
