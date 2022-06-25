class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        boolean event = intLength % 2 == 0;
        int n = event ? intLength / 2 : intLength / 2 + 1;
        int start = (int)Math.pow(10, n - 1);
        int m = queries.length;
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            StringBuilder left = new StringBuilder();
            left.append(start + queries[i] - 1);
            String cur = left.toString();
            String right = left.reverse().toString();
            cur += event ? right : right.substring(1);
            if (cur.length() == intLength) {
                ans[i] = Long.parseLong(cur);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}