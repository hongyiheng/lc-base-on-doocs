class Solution:
    def checkRecord(self, s: str) -> bool:
        a = l = 0
        for c in s:
            if c == 'A':
                a += 1
            if c == 'L':
                l += 1
            else:
                l = 0
            if a >= 2 or l >= 3:
                return False
        return True