class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        vis = {1}
        q = deque([(1, 1)])
        while q and t >= 0:
            for _ in range(len(q)):
                v, w = q.popleft()
                if t == 0 and v == target:
                    return w
                tmp = []
                for nv in g[v]:
                    if nv not in vis:
                        tmp.append(nv)
                        vis.add(nv)
                if not tmp and v == target:
                    return w
                for nv in tmp:
                    q.append((nv, w / len(tmp)))
            t -= 1
        return 0
