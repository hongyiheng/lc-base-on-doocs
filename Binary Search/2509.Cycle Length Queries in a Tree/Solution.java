class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            int a = q[0], b = q[1], cur = 0;
            while (a != b) {
                if (a < b) {
                    int tmp = b;
                    b = a;
                    a = tmp;
                }
                a >>= 1;
                cur++;
            }
            ans[idx++] = cur + 1;
        }
        return ans;
    }
}
