class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        def dfs(u, cur):
            if not g[u]:
                return cur
            ans = cur
            for v in g[u]:
                ans = max(ans, dfs(v, cur + informTime[u]))
            return ans

        g = defaultdict(list)
        for i, v in enumerate(manager):
            g[v].append(i)
        return dfs(headID, 0)