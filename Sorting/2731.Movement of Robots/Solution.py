class Solution:
    def sumDistance(self, nums: List[int], s: str, d: int) -> int:
        n = len(nums)
        for i in range(n):
            nums[i] += d if s[i] == 'R' else -d
        nums.sort()
        M = int(1e9 + 7)
        s = 0
        for i in range(1, n):
            s = (s + nums[i] - nums[0]) % M
        ans = s
        for i in range(1, n):
            s = (s - (n - i) * (nums[i] - nums[i - 1])) % M
            ans = (ans + s) % M
        return ans

