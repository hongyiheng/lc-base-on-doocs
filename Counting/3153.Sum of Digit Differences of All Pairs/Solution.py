class Solution:
    def sumDigitDifferences(self, nums: List[int]) -> int:
        m, n = len(nums), len(str(nums[0]))
        ans = 0
        s = [[0] * 10 for _ in range(n)]
        for i, v in enumerate(nums):
            for j in range(n):
                s[j][v % 10] += 1
                ans += i + 1 - s[j][v % 10]
                v //= 10
        return ans