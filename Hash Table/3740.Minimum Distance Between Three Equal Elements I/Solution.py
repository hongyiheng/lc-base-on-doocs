class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        g = defaultdict(list)
        ans = inf
        for i, v in enumerate(nums):
            g[v].append(i)
            if len(g[v]) > 3:
                g[v].pop(0)
            if len(g[v]) == 3:
                ans = min(ans, 2 * g[v][2] - 2 * g[v][0])
        return -1 if ans == inf else ans