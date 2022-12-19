class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        mp = defaultdict(list)
        for u, v in edges:
            mp[u].append(v)
            mp[v].append(u)
        vis = [False] * n
        q = deque([source])
        vis[source] = True
        while q:
            cur = q.popleft()
            if cur == destination:
                return True
            for nxt in mp[cur]:
                if not vis[nxt]:
                    vis[nxt] = True
                    q.append(nxt)
        return False
