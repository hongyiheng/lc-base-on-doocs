class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        cnt = [[False] * 2 for _ in range(26)]
        for c in word:
            v = ord(c)
            if 'a' <= c <= 'z':
                v -= ord('a')
                cnt[v][0] = True
            else:
                v -= ord('A')
                cnt[v][1] = True
        return sum(1 if a and b else 0 for a, b in cnt)
