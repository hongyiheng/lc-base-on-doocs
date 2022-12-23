class Solution:
    def smallestValue(self, n: int) -> int:
        while True:
            ans, x = 0, n
            i = 2
            while i * i <= x:
                while x % i == 0:
                    x //= i
                    ans += i
                i += 1
            if x >= 2:
                ans += x
            if ans == n:
                return ans
            n = ans