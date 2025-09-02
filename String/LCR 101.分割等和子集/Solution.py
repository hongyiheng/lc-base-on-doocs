class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2:
            return False
        t = s // 2
        f = [False] * (t + 1)
        f[0] = True
        for v in nums:
            for k in range(t, v - 1, -1):
                if f[k - v]:
                    f[k] = True
        return f[t]
