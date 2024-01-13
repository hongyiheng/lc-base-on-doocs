class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length, k = queries.length;
        int[] ans = new int[k];
        List<int[]> qs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            qs.add(new int[]{i, queries[i]});
        }
        qs.sort((a, b) -> a[1] - b[1]);
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int[] cnt = new int[n + 1];
        int l = 0, r = 0, cur = 0;
        for (int[] q : qs) {
            int i = q[0], v = q[1];
            while (r < m && logs[r][1] <= v) {
                if (cnt[logs[r][0]]++ == 0) {
                    cur++;
                }
                r++;
            }
            while (l < m && logs[l][1] < v - x) {
                if (--cnt[logs[l][0]] == 0) {
                    cur--;
                }
                l++;
            }
            ans[i] = n - cur;
        }
        return ans;
    }
}