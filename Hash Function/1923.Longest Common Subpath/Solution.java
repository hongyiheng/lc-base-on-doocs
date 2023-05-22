class Solution {

    int M = (int)1e9 + 7, m = 100010;
    long[] p1 = new long[m], p2 = new long[m];
    int base1 = 131, base2 = 1313131;

    public int longestCommonSubpath(int n, int[][] paths) {
        p1[0] = p2[0] = 1;
        for (int i = 1; i < m; i++) {
            p1[i] = p1[i - 1] * base1 % M;
            p2[i] = p2[i - 1] * base2 % M;
        }
        int l = 0, r = m;
        for (int[] s : paths) {
            r = Math.min(r, s.length);
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, paths)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k, int[][] paths) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] s : paths) {
            long h1 = 0, h2 = 0;
            Set<String> vis = new HashSet<>();
            int l = 0, r = 0;
            while (r < s.length) {
                h1 = (h1 * base1 + s[r]) % M;
                h2 = (h2 * base2 + s[r]) % M;
                if (r - l + 1 >= k) {
                    String h = h1 + "_" + h2;
                    if (!vis.contains(h)) {
                        vis.add(h);
                        cnt.put(h, cnt.getOrDefault(h, 0) + 1);
                    }
                    h1 = (h1 - s[l] * p1[k - 1] % M + M) % M;
                    h2 = (h2 - s[l] * p2[k - 1] % M + M) % M;
                    l++;
                }
                r++;
            }
        }
        for (int v : cnt.values()) {
            if (v == paths.length) {
                return true;
            }
        }
        return false;
    }
}
