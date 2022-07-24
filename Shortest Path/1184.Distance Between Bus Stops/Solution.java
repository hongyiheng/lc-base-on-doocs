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

class Solution {
    Edge[] edges;
    int[] head;
    int idx;

    public void addEdge(int a, int b, int w) {
        edges[idx] = new Edge(b, head[a], w);
        head[a] = idx++;
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        edges = new Edge[n * 2 + 1];
        head = new int[n + 1];
        idx = 1;
        for (int i = 0; i < n; i++) {
            addEdge(i, (i + 1) % n, distance[i]);
            addEdge((i + 1) % n, i, distance[i]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[start] = 0;
        q.add(new int[]{0, start});
        while (!q.isEmpty()) {
            int cur = q.poll()[1];
            for (int i = head[cur]; i != 0; i = edges[i].next) {
                int to = edges[i].to;
                if (dist[to] > dist[cur] + edges[i].w) {
                    dist[to] = dist[cur] + edges[i].w;
                    q.add(new int[] {dist[to], to});
                }
            }
        }
        return dist[destination];
    }
}