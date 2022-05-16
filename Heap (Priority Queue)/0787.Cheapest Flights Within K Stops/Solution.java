class Solution {
    Edge[] edge;
    int[] head;
    int idx = 1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        edge = new Edge[n * n];
        head = new int[n];
        for (int[] e : flights) {
            addEdge(e[0], e[1], e[2]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{src, 0});
        while (k >= 0 && !q.isEmpty()) {
            List<int[]> tmp = new ArrayList<>();
            k--;
            int m = q.size();
            for (int i = 0; i < m; i++) {
                int[] cur = q.poll();
                for (int j = head[cur[0]]; j != 0; j = edge[j].next) {
                    if (dist[edge[j].to] <= edge[j].w + cur[1]) {
                        continue;
                    }
                    dist[edge[j].to] = edge[j].w + cur[1];
                    tmp.add(new int[]{edge[j].to, edge[j].w + cur[1]});
                }
            }
            for (int[] item : tmp) {
                q.add(item);
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public void addEdge(int a, int b, int w) {
        edge[idx] = new Edge(b, head[a], w);
        head[a] = idx++;
    }

    class Edge {
        int to;
        int next;
        int w;

        public Edge(int to, int next, int w) {
            this.to = to;
            this.next = next;
            this.w = w;
        }
    }
}