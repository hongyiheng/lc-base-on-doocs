class Solution:
    def doesAliceWin(self, s: str) -> bool:
        cnt = 0
        for c in s:
            if c in {'a', 'e', 'i', 'o', 'u'}:
                cnt += 1
        return cnt != 0