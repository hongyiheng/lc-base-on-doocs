class Solution:
    def doesAliceWin(self, s: str) -> bool:
        for c in list(s):
            if c in 'aeiou':
                return True
        return False
