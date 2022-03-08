class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] left = new int[n], right = new int[n], sum = new int[n];
        char[] chars = s.toCharArray();
        int l = -1, r = -1, cnt = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (chars[i] == '*') {
                ++cnt;
            }
            if (chars[i] == '|') {
                l = i;
            }
            if (chars[j] == '|') {
                r = j;
            }
            left[i] = l;
            right[j] = r;
            sum[i] = cnt;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (right[a] != -1 && left[b] != -1 && right[a] < left[b]) {
                ans[i] = sum[left[b]] - sum[right[a]];
            }
        }
        return ans;
    }
}