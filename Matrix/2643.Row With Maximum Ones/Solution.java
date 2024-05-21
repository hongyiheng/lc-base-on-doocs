class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans = 0, mx = 0;
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int v : mat[i]) {
                cnt += v;
            }
            if (cnt > mx) {
                mx = cnt;
                ans = i;
            }
        }
        return new int[]{ans, mx};
    }
}