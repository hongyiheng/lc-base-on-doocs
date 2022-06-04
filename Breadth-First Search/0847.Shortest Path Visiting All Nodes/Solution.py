
class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        n = len(graph)
        mask = 1 << n
        dis = [[float('inf')] * n for _ in range(mask)]
        q = deque()
        for i in range(n):
            dis[1 << i][i] = 0
            q.append([1 << i, i])
        while q:
            state, idx = q.popleft()
            step = dis[state][idx]
            for i in graph[idx]:
                next_state = 1 << i | state
                if dis[next_state][i] > step + 1:
                    dis[next_state][i] = step + 1
                    q.append([next_state, i])
        ans = float('inf')
        for i in range(n):
            ans = min(ans, dis[mask - 1][i])
        return ans