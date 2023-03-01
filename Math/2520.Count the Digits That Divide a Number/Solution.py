class Solution:
    def countDigits(self, num: int) -> int:
        ans, v = 0, num
        while v:
            if num % (v % 10) == 0:
                ans += 1
            v //= 10
        return ans