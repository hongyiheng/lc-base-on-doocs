class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        n = len(arr)
        f = [[-inf] * 2 for _ in range(n + 1)]
        ans = arr[0]
        for i, v in enumerate(arr):
            f[i + 1][0] = max(f[i][0], 0) + v
            f[i + 1][1] = max(f[i][0], f[i][1] + v)
            ans = max(ans, f[i + 1][0], f[i + 1][1])
        return ans