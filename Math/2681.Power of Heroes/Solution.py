class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        MOD = int(1e9 + 7)
        nums.sort()
        ans = s = 0
        for v in nums:
            ans = (ans + v * v * (s + v)) % MOD
            s = (2 * s + v) % MOD
        return ans
