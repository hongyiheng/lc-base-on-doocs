class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        s = {0}
        for i in range(c + 1):
            if i * i > c:
                return False
            s.add(i * i)
            if c - i * i in s:
                return True
            i += 1
        return False