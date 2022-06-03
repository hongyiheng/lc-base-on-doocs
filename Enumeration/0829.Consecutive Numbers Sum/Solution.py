class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        ans = 1
        for k in range(2, n):
            a = (2 * n // k - k + 1) // 2
            if a < 1:
                break
            elif n == (2 * a + k - 1) * k // 2:
                ans += 1
        return ans