class Solution {
    int[] p;
    int need, extra;
    public int makeConnected(int n, int[][] connections) {
        need = n - 1;
        p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int[] item : connections) {
            union(item[0], item[1]);
        }
        return extra < need ? -1 : need;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
            need--;
        } else {
            extra++;
        }
    }
}