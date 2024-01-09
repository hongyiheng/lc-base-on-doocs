class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        ans = 0
        for i in range(1, k // 2 + 1):
            if not n:
                break
            ans += i
            n -= 1
        while n:
            ans += k
            k += 1
            n -= 1
        return ans
