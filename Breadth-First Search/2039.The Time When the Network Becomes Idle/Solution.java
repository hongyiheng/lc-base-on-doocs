class Solution {
        int N = 100010, M = N * 2;
        int[] to = new int[M], head = new int[N], next = new int[M];
        int[] dist = new int[N];
        int idx = 0;

        void add(int a, int b) {
            to[idx] = b;
            next[idx] = head[a];
            head[a] = idx++;
        }

        public int networkBecomesIdle(int[][] edges, int[] patience) {
            Arrays.fill(head, -1);
            Arrays.fill(dist, Integer.MAX_VALUE);
            int n = patience.length;
            for (int[] e : edges) {
                add(e[0], e[1]);
                add(e[1], e[0]);
            }
            Deque<Integer> q = new ArrayDeque<>();
            // 源点 0
            q.addLast(0);
            dist[0] = 0;
            while (!q.isEmpty()) {
                int t = q.pollFirst();
                // i = head[t] 为节点 t 最近指向的节点
                // i == -1 表示 t 节点没有指向任何节点
                // next[i] 表示 i 节点指向的下一个节点
                for (int i = head[t]; i != -1; i = next[i]) {
                    // i 节点指向的节点 i -> j
                    int j = to[i];
                    if (dist[j] != Integer.MAX_VALUE) {
                        continue;
                    }
                    // 更新 j 到源点的距离
                    dist[j] = dist[t] + 1;
                    q.addLast(j);
                }
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                int di = dist[i] * 2, t = patience[i];
                int cur = di <= t ? di : (di - 1) / t * t + di;
                ans = Math.max(ans, cur);
            }
            return ans + 1;
        }
    }