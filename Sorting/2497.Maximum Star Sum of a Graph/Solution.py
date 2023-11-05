class Solution:
    def maxStarSum(self, vals: List[int], edges: List[List[int]], k: int) -> int:
        if k == 0:
            return max(vals)

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        ans = max(vals)
        for u in range(len(vals)):
            vs = [vals[v] for v in g[u] if vals[v] > 0]
            s = vals[u] + sum(sorted(vs, reverse=True)[:min(len(vs), k)])
            ans = max(ans, s)
        return ans