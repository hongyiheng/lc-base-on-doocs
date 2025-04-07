class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2:
            return False
        t = s // 2
        n = len(nums)
        f = [[False] * (t + 1) for _ in range(n + 1)]
        f[0][0] = True
        for i in range(n):
            for j in range(t + 1):
                f[i + 1][j] = f[i][j]
                if j >= nums[i]:
                    f[i + 1][j] |= f[i][j - nums[i]]
        return f[n][t]

