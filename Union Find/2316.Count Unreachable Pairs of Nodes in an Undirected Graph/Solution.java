class Solution {

    int[] p;
    int[] cnt;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int r1 = find(a), r2 = find(b);
        if (r1 != r2) {
            cnt[r2] += cnt[r1];
            cnt[r1] = 0;
            p[r1] = r2;
        }
    }

    public long countPairs(int n, int[][] edges) {
        p = new int[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        long ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != i) {
                continue;
            }
            ans += pre * cnt[i];
            pre += cnt[i];
        }
        return ans;
    }
}