class Solution:
    def rotatedDigits(self, n: int) -> int:
        nums = [0, 1, 2, 5, 6, 8, 9]
        valid = [2, 5, 6, 9]
        ans = 0
        for i in range(n + 1):
            cur = i
            flag = False
            while cur > 0:
                if cur % 10 not in nums:
                    break
                if cur % 10 in valid:
                    flag = True
                cur //= 10
            if cur <= 0 and flag:
                ans += 1
        return ans
