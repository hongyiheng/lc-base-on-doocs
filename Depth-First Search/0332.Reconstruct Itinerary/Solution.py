class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        def dfs(path):
            nonlocal n
            if len(path) == n + 1:
                return path

            res = None
            u = path[-1]
            for v in sorted(g[u]):
                g[u].remove(v)
                path.append(v)
                res = dfs(path)
                if res:
                    break
                path.pop()
                g[u].append(v)
            return res

        g = defaultdict(list)
        for u, v in tickets:
            g[u].append(v)
        n = len(tickets)

        return dfs(["JFK"])