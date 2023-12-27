class Solution:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        t1 = t2 = d1 = d2 = 0
        for a, b in zip(player1, player2):
            t1 += 2 * a if d1 > 0 else a
            t2 += 2 * b if d2 > 0 else b
            d1 = 2 if a == 10 else d1 - 1
            d2 = 2 if b == 10 else d2 - 1
        if t1 == t2:
            return 0
        return 1 if t1 > t2 else 2