class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        ans = 0
        g = defaultdict(int)
        for i, v in enumerate(nums):
            ans += g[v - i]
            g[v - i] += 1
        n = len(nums)
        return n * (n - 1) // 2 - ans
            