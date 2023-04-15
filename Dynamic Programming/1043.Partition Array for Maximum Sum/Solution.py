class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        f = [0] * n
        for i in range(k):
            f[i] = max(arr[:i + 1]) * (i + 1)
        for i in range(k, n):
            for j in range(k):
                f[i] = max(f[i], f[i - j - 1] + max(arr[i - j:i + 1]) * (j + 1))
        return f[-1]