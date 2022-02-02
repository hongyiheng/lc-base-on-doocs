class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        edge = [[float('inf')] * (n + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            edge[i][i] = 0
        for t in times:
            edge[t[0]][t[1]] = t[2]
        dist = [float('inf')] * (n + 1)

        def dijkstra():
            vis = [False] * (n + 1)
            dist[k] = 0
            for _ in range(1, n + 1):
                index = -1
                for i in range(1, n + 1):
                    if vis[i]:
                        continue
                    if index == -1 or dist[index] > dist[i]:
                        index = i
                vis[index] = True
                for j in range(1, n + 1):
                    dist[j] = min(dist[j], dist[index] + edge[index][j])

        dijkstra()
        ans = 0
        for i in range(1, n + 1):
            ans = max(ans, dist[i])
        return -1 if ans == float('inf') else ans

