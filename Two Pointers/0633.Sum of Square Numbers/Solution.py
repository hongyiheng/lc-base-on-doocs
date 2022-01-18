class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        i, j = 0, int(math.sqrt(c))
        while i <= j:
            cur = i * i + j * j
            if cur == c:
                return True
            if cur > c:
                j -= 1
            else:
                i += 1
        return False