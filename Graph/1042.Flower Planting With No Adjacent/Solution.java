class Solution {
    int[] head;
    Edge[] edges;
    int idx = 1;

    public void addEdge(int a, int b) {
        edges[idx] = new Edge(b, head[a]);
        head[a] = idx++;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        head = new int[n + 1];
        edges = new Edge[paths.length * 2 + 1];
        for (int[] path : paths) {
            addEdge(path[0] - 1, path[1] - 1);
            addEdge(path[1] - 1, path[0] - 1);
        }
        int[] cnt = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int k = 1;
            while (k <= 4) {
                if ((cnt[i] & (1 << k)) == 0) {
                    ans[i] = k;
                    break;
                }
                k++;
            }
            for (int j = head[i]; j != 0; j = edges[j].next) {
                cnt[edges[j].to] |= (1 << k);
            }
        }
        return ans;
    }
}

class Edge {
    int to;
    int next;

    public Edge(int to, int next) {
        this.to = to;
        this.next = next;
    }
}