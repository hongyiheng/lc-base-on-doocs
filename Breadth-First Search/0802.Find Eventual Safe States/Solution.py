class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        cnt = [0] * n
        g = defaultdict(list)
        for u in range(n):
            for v in graph[u]:
                g[v].append(u)
                cnt[u] += 1
        q = deque()
        for i in range(n):
            if cnt[i] == 0:
                q.append(i)
        while q:
            u = q.popleft()
            for v in g[u]:
                cnt[v] -= 1
                if cnt[v] == 0:
                    q.append(v)
        ans = []
        for i in range(n):
            if cnt[i] == 0:
                ans.append(i)
        return ans