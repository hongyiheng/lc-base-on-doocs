class Solution:
    def losingPlayer(self, x: int, y: int) -> str:
        ans = min(x, y // 4)
        return "Alice" if ans % 2 == 1 else "Bob"