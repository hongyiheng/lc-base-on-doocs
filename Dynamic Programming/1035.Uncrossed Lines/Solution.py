class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        f = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                f[i][j] = max(f[i][j - 1], f[i - 1][j])
                if nums1[i - 1] == nums2[j - 1]:
                    f[i][j] = max(f[i][j], f[i - 1][j - 1] + 1)
        return f[n][m]