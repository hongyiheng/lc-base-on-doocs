class Solution:
    def countPrimes(self, n: int) -> int:
        nums = [False] * n
        for i in range(2, n):
            if not nums[i]:
                x = i * i
                while x < n:
                    nums[x] = True
                    x += i
        ans = 0
        for i in range(2, n):
            if not nums[i]:
                ans += 1
        return ans
