class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        f = [0] * 3
        for v in nums:
            a, b, c = f[0] + v, f[1] + v, f[2] + v
            f[a % 3] = max(f[a % 3], a)
            f[b % 3] = max(f[b % 3], b)
            f[c % 3] = max(f[c % 3], c)
        return f[0]
