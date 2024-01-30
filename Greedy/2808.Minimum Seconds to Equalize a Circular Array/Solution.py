class Solution:
    def minimumSeconds(self, nums: List[int]) -> int:
        ans = n = len(nums)
        g = defaultdict(list)
        for i, v in enumerate(nums):
            g[v].append(i)
        for q in g.values():
            d = n - (q[-1] - q[0] + 1)
            for i in range(1, len(q)):
                d = max(d, q[i] - q[i - 1] - 1)
            ans = min((d + 1) // 2, ans)
        return ans