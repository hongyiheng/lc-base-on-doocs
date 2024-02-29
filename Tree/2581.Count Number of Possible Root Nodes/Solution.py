class Solution:
    def rootCount(self, edges: List[List[int]], guesses: List[List[int]], k: int) -> int:
        def dfs(u, p):
            nonlocal cnt
            for v in g[u]:
                if v != p:
                    cnt += (u, v) in s
                    dfs(v, u)

        def reroot(u, p, cnt):
            nonlocal ans
            ans += cnt >= k
            for v in g[u]:
                if v != p:
                    reroot(v, u, cnt - ((u, v) in s) + ((v, u) in s))

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        s = {(u, v) for u, v in guesses}
        ans = cnt = 0
        dfs(0, -1)
        reroot(0, -1, cnt)
        return ans