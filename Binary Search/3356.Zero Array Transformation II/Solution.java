class Solution {

    public boolean check(int[] nums, int[][] queries, int t) {
        int[] q = new int[nums.length + 1];
        for (int i = 0; i < t; i++) {
            int[] v = queries[i];
            q[v[0]] += v[2];
            q[v[1] + 1] -= v[2];
        }
        int d = 0;
        for (int i = 0; i < nums.length; i++) {
            d += q[i];
            if (nums[i] > d) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, r = queries.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, queries, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return check(nums, queries, r) ? r : -1;
    }
}