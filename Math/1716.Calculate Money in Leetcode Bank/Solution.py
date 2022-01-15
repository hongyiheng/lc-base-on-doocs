class Solution:
    def totalMoney(self, n: int) -> int:
        week, rest = n // 7, n % 7
        m = [1, 2, 3, 4, 5, 6, 7]
        ans = 0
        while week > 0:
            for i, v in enumerate(m):
                ans += v
                m[i] += 1
            week -= 1
        for i in range(rest):
            ans += m[i]
        return ans