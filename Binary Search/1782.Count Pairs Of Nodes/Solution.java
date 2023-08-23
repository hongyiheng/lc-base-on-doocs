class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int M = 20010;
        int[] cnt = new int[n + 1];
        Map<Integer, Integer> g = new HashMap<>();
        for (int[] e : edges) {
            int u = Math.min(e[0], e[1]);
            int v = Math.max(e[0], e[1]);
            cnt[u]++;
            cnt[v]++;
            int k = u * M + v;
            g.put(k, g.getOrDefault(k, 0) + 1);
        }
        int[] s = cnt.clone();
        Arrays.sort(s);
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int t = queries[i];
            for (int j = 1; j < n + 1; j++) {
                int l = j + 1, r = n + 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (s[j] + s[mid] <= t) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans[i] += n - l + 1;
            }
            for (Map.Entry<Integer, Integer> entry : g.entrySet()) {
                int a = entry.getKey() / M, b = entry.getKey() % M;
                int v = entry.getValue();
                if (cnt[a] + cnt[b] > t && cnt[a] + cnt[b] - v <= t) {
                    ans[i]--;
                }
            }
        }
        return ans;
    }
}