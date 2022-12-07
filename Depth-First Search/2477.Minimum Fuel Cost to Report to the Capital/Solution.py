class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        def dfs(u, p):
            nonlocal ans, seats
            cnt = 1
            for v in mp[u]:
                if v == p:
                    continue
                cnt += dfs(v, u)
            if u != 0:
                ans += (cnt + seats - 1) // seats
            return cnt

        mp = defaultdict(list)
        for u, v in roads:
            mp[u].append(v)
            mp[v].append(u)
        ans = 0
        dfs(0, -1)
        return ans
