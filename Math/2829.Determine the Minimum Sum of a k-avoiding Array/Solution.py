class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        ans = 0
        for i in range(1, k // 2 + 1):
            ans += i
            n -= 1
            if n == 0:
                return ans
        while n:
            ans += k
            k += 1
            n -= 1
        return ans