class Solution:
    def placedCoins(self, edges: List[List[int]], cost: List[int]) -> List[int]:
        def dfs(u, p) -> List[List[int]]:
            pos, neg = [], []
            if cost[u] >= 0:
                pos.append(cost[u])
            else:
                neg.append(cost[u])
            for v in g[u]:
                if v == p:
                    continue
                ps, ng = dfs(v, u)
                pos.extend(ps)
                neg.extend(ng)
            if len(pos) + len(neg) >= 3:
                pos.sort(reverse=True)
                neg.sort()
                if len(pos) >= 3:
                    ans[u] = pos[0] * pos[1] * pos[2]
                if len(pos) >= 1 and len(neg) >= 2:
                    ans[u] = max(ans[u], pos[0] * neg[0] * neg[1])
                pos = pos[:3]
                neg = neg[:2]
            else:
                ans[u] = 1
            return [pos, neg]

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = [0] * len(cost)
        dfs(0, -1)
        return ans