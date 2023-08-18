class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        def get_max(arr):
            m = len(arr)
            f = [[0] * (k + 1) for _ in range(m + 1)]
            for i in range(1, m + 1):
                for j in range(1, k + 1):
                    f[i][j] = max(f[i - 1][j], (f[i - 2][j - 1] if i >= 2 else 0) + arr[i - 1])
            return f[m][k]

        n, k = len(slices), len(slices) // 3
        return max(get_max(slices[1:]), get_max(slices[:-1]))