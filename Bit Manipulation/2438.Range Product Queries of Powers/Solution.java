class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] powers = new int[32];
        int j = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                powers[j++] = 1 << i;
            }
        }
        int mod = (int)1e9 + 7;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long v = 1;
            for (int k = l; k <= r; k++) {
                v = (v * powers[k]) % mod;
            }
            ans[i] = (int) v;
        }
        return ans;
    }
}
