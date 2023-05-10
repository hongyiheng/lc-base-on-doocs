import java.math.BigInteger;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> q = new ArrayList<>();
        for (int i = 30; i > -1; i--) {
            if ((1 << i) <= n) {
                q.add(1 << i);
                n -= 1 << i;
            }
        }
        Collections.reverse(q);
        int k = q.size();
        BigInteger[] pre = new BigInteger[k + 1];
        pre[0] = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            pre[i + 1] = pre[i].multiply(new BigInteger(String.valueOf(q.get(i))));
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = pre[queries[i][1] + 1].divide(pre[queries[i][0]]).remainder(new BigInteger(String.valueOf(1000000007))).intValue();
        }
        return ans;
    }
}
