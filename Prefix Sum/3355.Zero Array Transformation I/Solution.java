class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] q = new int[n + 2];
        for (int[] e : queries) {
            q[e[0]]++;
            q[e[1] + 1]--;
        }
        int d = 0;
        for (int i = 0; i < n; i++) {
            d += q[i];
            if (nums[i] > d) {
                return false;
            }
        }
        return true;
    }
}