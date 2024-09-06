class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        f = [[1] * (k + 1) for _ in range(n)]
        ans = 0
        for i in range(n):
            for d in range(k + 1):
                for j in range(i):
                    if nums[i] == nums[j]:
                        f[i][d] = max(f[i][d], f[j][d] + 1)
                    elif d:
                        f[i][d] = max(f[i][d], f[j][d - 1] + 1)
                ans = max(ans, f[i][d])
        return ans