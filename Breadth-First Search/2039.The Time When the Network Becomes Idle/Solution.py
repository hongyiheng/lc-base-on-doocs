class Solution:
    def networkBecomesIdle(self, edges: List[List[int]], patience: List[int]) -> int:
        N = 100010
        M = 2 * N
        head, next, edge = [-1] * N, [0] * M, [0] * M
        dist = [float('inf')] * N
        idx = 0

        def add(a, b):
            nonlocal head, next, edge, idx
            edge[idx] = b
            next[idx] = head[a]
            head[a] = idx
            idx += 1

        n = len(patience)
        for e in edges:
            add(e[0], e[1])
            add(e[1], e[0])

        q = deque()
        q.append(0)
        dist[0] = 0
        while q:
            t = q.popleft()
            i = head[t]
            while i != -1:
                j = edge[i]
                if dist[j] == float('inf'):
                    dist[j] = dist[t] + 1
                    q.append(j)
                i = next[i]
        ans = 0
        for i in range(1, n):
            di, t = dist[i] * 2, patience[i]
            cur = di if di <= t else (di - 1) // t * t + di
            ans = max(ans, cur)
        return ans + 1