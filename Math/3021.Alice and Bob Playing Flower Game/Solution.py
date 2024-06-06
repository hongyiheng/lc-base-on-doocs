class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        return n // 2 * (m - m // 2) + m // 2 * (n - n // 2)