class Solution:
    def minimumTime(self, n: int, edges: List[List[int]], disappear: List[int]) -> List[int]:
        g = defaultdict(list)
        for u, v, w in edges:
            g[u].append([v, w])
            g[v].append([u, w])
        ans = [-1] * n
        ans[0] = 0
        q = [[0, 0]]
        while q:
            t, u = heapq.heappop(q)
            if t > ans[u]:
                continue
            for v, w in g[u]:
                if t + w >= disappear[v]:
                    continue
                if ans[v] == -1 or ans[v] > t + w:
                    ans[v] = t + w
                    heapq.heappush(q, [t + w, v])
        return ans
