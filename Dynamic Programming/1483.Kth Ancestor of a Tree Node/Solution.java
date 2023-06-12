class TreeAncestor {

    int[][] p;

    public TreeAncestor(int n, int[] parent) {
        p = new int[n][17];
        for (int[] r : p) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < n; i++) {
            p[i][0] = parent[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 17; j++) {
                if (p[i][j - 1] == -1) {
                    continue;
                }
                p[i][j] = p[p[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < 17; i++) {
            if ((k & (1 << i)) != 0 && node != -1) {
                node = p[node][i];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */