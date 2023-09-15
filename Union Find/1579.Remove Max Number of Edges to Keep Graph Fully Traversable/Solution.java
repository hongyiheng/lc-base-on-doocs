class Solution {

    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public boolean isLinked() {
        int t = find(1);
        for (int i = 1; i < p.length; i++) {
            if (find(i) != t) {
                return false;
            }
        }
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        p = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            p[i] = i;
        }
        int ans = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (find(e[1]) == find(e[2])) {
                    ans++;
                } else {
                    union(e[1], e[2]);
                }
            }
        }
        int[] tmp = p.clone();
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (find(e[1]) == find(e[2])) {
                    ans++;
                } else {
                    union(e[1], e[2]);
                }
            }
        }
        if (!isLinked()) {
            return -1;
        }
        p = tmp;
        for (int[] e : edges) {
            if (e[0] == 2) {
                if (find(e[1]) == find(e[2])) {
                    ans++;
                } else {
                    union(e[1], e[2]);
                }
            }
        }
        return isLinked() ? ans : -1;
    }
}