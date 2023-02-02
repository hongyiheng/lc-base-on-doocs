class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        r, b = defaultdict(list), defaultdict(list)
        for u, v in redEdges:
            r[u].append(v)
        for u, v in blueEdges:
            b[u].append(v)
        dist = [[-1] * 2 for _ in range(n)]
        dist[0] = [0, 0]
        q = deque()
        q.append(0)
        while q:
            u = q.popleft()
            if dist[u][0] != -1:
                for v in r[u]:
                    if dist[v][1] == -1 or dist[v][1] > dist[u][0] + 1:
                        dist[v][1] = dist[u][0] + 1
                        q.append(v)
            if dist[u][1] != -1:
                for v in b[u]:
                    if dist[v][0] == -1 or dist[v][0] > dist[u][1] + 1:
                        dist[v][0] = dist[u][1] + 1
                        q.append(v)
        ans = list()
        for a, b in dist:
            if a != -1 and b != -1:
                ans.append(min(a, b))
            elif a != -1:
                ans.append(a)
            elif b != -1:
                ans.append(b)
            else:
                ans.append(-1)
        return ans