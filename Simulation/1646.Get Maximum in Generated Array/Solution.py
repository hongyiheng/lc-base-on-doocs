class Solution:
    def getMaximumGenerated(self, n: int) -> int:
        arr = [0] * (n + 1)
        ans = 0
        for i in range(n + 1):
            if i == 0 or i == 1:
                arr[i] = i
            if 2 <= 2 * i and 2 * i <= n:
                arr[2 * i] = arr[i]
            if 2 <= 2 * i + 1 and 2 * i + 1 <= n:
                arr[2 * i + 1] = arr[i] + arr[i + 1]
            ans = max(ans, arr[i])
        return ans