class Graph {

        int[][] g;
        int n, inf;

        public Graph(int n, int[][] edges) {
            this.n = n;
            inf = Integer.MAX_VALUE;
            g = new int[n][n];
            for (int[] r : g) {
                Arrays.fill(r, inf);
            }
            for (int i = 0; i < n; i++) {
                g[i][i] = 0;
            }
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                g[u][v] = w;
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (g[i][k] != inf && g[k][j] != inf) {
                            g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                        }
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            int u = edge[0], v = edge[1], w = edge[2];
            g[u][v] = Math.min(g[u][v], w);
            for (int k : new int[]{u, v}) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (g[i][k] != inf && g[k][j] != inf) {
                            g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                        }
                    }
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            System.out.println(g[node1][node2]);
            return g[node1][node2] == inf ? -1 : g[node1][node2];
        }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */