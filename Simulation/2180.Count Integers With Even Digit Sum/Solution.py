class Solution:
    def countEven(self, num: int) -> int:
        ans = 0
        for i in range(2, num + 1):
            v, cnt = i, 0
            while v:
                cnt += v % 10
                v //= 10
            if cnt % 2 == 0:
                ans += 1
        return ans