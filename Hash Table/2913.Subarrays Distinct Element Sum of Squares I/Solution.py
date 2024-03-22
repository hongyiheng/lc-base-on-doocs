class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        MOD = int(1e9 + 7)
        n = len(nums)
        ans = 0
        for i in range(n):
            s = set()
            for j in range(i, n):
                s.add(nums[j])
                ans = (ans + len(s) ** 2) % MOD
        return ans
