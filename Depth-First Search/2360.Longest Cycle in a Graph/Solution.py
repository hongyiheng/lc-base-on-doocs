class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        def dfs(x):
            nonlocal t, ans
            if time[x]:
                return
            st = t
            while x != -1:
                if time[x]:
                    if time[x] >= st:
                        ans = max(ans, t - time[x])
                    break
                else:
                    time[x] = t
                    t += 1
                x = edges[x]

        n = len(edges)
        time = [0] * n
        ans, t = -1, 1
        for i in range(n):
            dfs(i)
        return ans