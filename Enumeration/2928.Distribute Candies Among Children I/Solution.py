class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        ans = 0
        for i in range(min(n, limit) + 1):
            for j in range(min(n - i, limit) + 1):
                if n - i - j <= limit:
                    ans += 1
        return ans