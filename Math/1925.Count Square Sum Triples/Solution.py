class Solution:
    def countTriples(self, n: int) -> int:
        ans = 0
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                c = math.sqrt(i * i + j * j)
                if c % 1 == 0 and c <= n:
                    ans += 2
        return ans